package com.upgrad.imageguru.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.upgrad.imageguru.R;
import com.upgrad.imageguru.model.GalleryResponse;
import com.upgrad.imageguru.services.FetchGalleryService;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new FetchGalleryService(this).Execute("lDRB2", new UiCallback());

    }

    private class UiCallback implements Callback<GalleryResponse> {

        @Override
        public void success(GalleryResponse galleryResponse, Response response) {
            galleryResponse.getData().getImages();
        }

        @Override
        public void failure(RetrofitError error) {
            //Assume we have no connection, since error is null
            if (error == null) {
                Snackbar.make(findViewById(R.id.rootView), "No internet connection", Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}