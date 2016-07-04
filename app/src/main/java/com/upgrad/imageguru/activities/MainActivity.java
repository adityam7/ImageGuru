package com.upgrad.imageguru.activities;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.upgrad.imageguru.R;
import com.upgrad.imageguru.adapter.TagRecyclerViewAdapter;
import com.upgrad.imageguru.model.tag.TagItem;
import com.upgrad.imageguru.model.tag.TagResponse;
import com.upgrad.imageguru.services.FetchTagService;
import com.upgrad.imageguru.utils.Constants;

import java.util.Arrays;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    RecyclerView mImagesRecyclerView;
    TagRecyclerViewAdapter mAdapter;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    Parcelable mLayoutManagerSavedState;
    SearchView mSearchView;
    String mSearchTag;
    SharedPreferences mPrefs;
    SharedPreferences.Editor mEdit;

    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPrefs = getSharedPreferences(Constants.TAG_PREFS, MODE_PRIVATE);
        mSearchTag = mPrefs.getString(Constants.TAG_SEARCH, Constants.TAG_DEFAULT_SEARCH);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.logo);
        mToolbar.setTitle(mSearchTag);
        setSupportActionBar(mToolbar);

        mImagesRecyclerView = (RecyclerView) findViewById(R.id.tag_recycler_view);

        new FetchTagService(this).Execute(mSearchTag, new UiCallback());
        progress = new ProgressDialog(MainActivity.this);
        progress.setTitle("Loading...");
        progress.setMessage("Please Wait!!!");
        progress.setCancelable(true);
        progress.show();
    }

    private class UiCallback implements Callback<TagResponse> {

        @Override
        public void success(TagResponse tagResponse, Response response) {
            mAdapter = new TagRecyclerViewAdapter(getApplicationContext(),
                    Arrays.asList(tagResponse.getData().getItems()),
                    new TagRecyclerViewAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(TagItem item) {
                            if (item.is_album()) {
                                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                                intent.putExtra(Constants.EXTRA_ITEM, item);
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                                intent.putExtra(Constants.EXTRA_TYPE, Constants.TYPE_TAG);
                                intent.putExtra(Constants.EXTRA_ITEM, item);
                                startActivity(intent);
                            }
                        }
                    });
            mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
            mImagesRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
            restoreLayoutManagerPosition();
            mImagesRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mImagesRecyclerView.setAdapter(mAdapter);
            if (progress.isShowing())
                progress.dismiss();
        }

        @Override
        public void failure(RetrofitError error) {
            if (error == null) {
                Snackbar.make(findViewById(R.id.rootView), "No internet connection", Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(Constants.SAVED_LAYOUT_MANAGER_STATE, mImagesRecyclerView.getLayoutManager().onSaveInstanceState());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mLayoutManagerSavedState = savedInstanceState.getParcelable(Constants.SAVED_LAYOUT_MANAGER_STATE);
    }

    private void restoreLayoutManagerPosition() {
        if (mLayoutManagerSavedState != null) {
            mImagesRecyclerView.getLayoutManager().onRestoreInstanceState(mLayoutManagerSavedState);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        mSearchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        mSearchView.onActionViewCollapsed();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mSearchTag = query;
                mEdit = mPrefs.edit();
                mEdit.putString(Constants.TAG_SEARCH, mSearchTag);
                mEdit.apply();
                mSearchView.setQuery("", false);
                mSearchView.setIconified(true);
                mToolbar.setTitle(mSearchTag);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                new FetchTagService(MainActivity.this).Execute(mSearchTag, new UiCallback());
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}