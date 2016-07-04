package com.upgrad.imageguru.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.upgrad.imageguru.R;
import com.upgrad.imageguru.adapter.GalleryRecyclerViewAdapter;
import com.upgrad.imageguru.model.gallery.GalleryImage;
import com.upgrad.imageguru.model.gallery.GalleryResponse;
import com.upgrad.imageguru.model.tag.TagItem;
import com.upgrad.imageguru.services.FetchGalleryService;
import com.upgrad.imageguru.utils.Constants;

import java.util.Arrays;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GalleryActivity extends AppCompatActivity {

    TagItem mItem;
    RecyclerView mGalleryRecyclerView;
    GalleryRecyclerViewAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mItem = (TagItem) getIntent().getSerializableExtra(Constants.EXTRA_ITEM);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(mItem.getTitle() + " Gallery");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mGalleryRecyclerView = (RecyclerView) findViewById(R.id.gallery_recycler_view);

        new FetchGalleryService(this).Execute(mItem.getId(), new UiCallback());
    }

    private class UiCallback implements Callback<GalleryResponse> {

        @Override
        public void success(GalleryResponse galleryResponse, Response response) {
            mAdapter = new GalleryRecyclerViewAdapter(getApplicationContext(),
                    Arrays.asList(galleryResponse.getData().getImages()),
                    new GalleryRecyclerViewAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(GalleryImage image) {
                            Intent intent = new Intent(GalleryActivity.this, ImageActivity.class);
                            intent.putExtra(Constants.EXTRA_TYPE, Constants.TYPE_GALLERY);
                            intent.putExtra(Constants.EXTRA_IMAGE, image);
                            intent.putExtra(Constants.EXTRA_GALLERY_TITLE, mItem.getTitle());
                            startActivity(intent);
                        }
                    });
            mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
            mGalleryRecyclerView.setLayoutManager(mLayoutManager);
            mGalleryRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mGalleryRecyclerView.setAdapter(mAdapter);
        }

        @Override
        public void failure(RetrofitError error) {
            if (error == null) {
                Snackbar.make(findViewById(R.id.rootView), "No internet connection", Snackbar.LENGTH_SHORT).show();
            }
        }
    }

}
