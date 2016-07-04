package com.upgrad.imageguru.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.upgrad.imageguru.R;
import com.upgrad.imageguru.model.gallery.GalleryImage;
import com.upgrad.imageguru.model.tag.TagItem;
import com.upgrad.imageguru.utils.Constants;

public class ImageActivity extends AppCompatActivity {

    TagItem mItem;
    GalleryImage mImage;
    String mGalleryTitle;
    boolean isTagImage = true;

    FloatingActionButton mFab;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        if (getIntent().getStringExtra(Constants.EXTRA_TYPE).equals(Constants.TYPE_TAG)) {
            isTagImage = true;
            mItem = (TagItem) getIntent().getSerializableExtra(Constants.EXTRA_ITEM);
        } else {
            isTagImage = false;
            mImage = (GalleryImage) getIntent().getSerializableExtra(Constants.EXTRA_IMAGE);
            mGalleryTitle = getIntent().getStringExtra(Constants.EXTRA_GALLERY_TITLE);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (isTagImage)
            toolbar.setTitle(mItem.getTitle());
        else {
            if (mImage.getTitle() != null && mImage.getTitle().equals("")) {
                toolbar.setTitle(mGalleryTitle);
            } else {
                toolbar.setTitle(mImage.getTitle());
            }
        }
        setSupportActionBar(toolbar);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mImageView = (ImageView) findViewById(R.id.image);

        if (isTagImage) {
            Glide.with(getApplicationContext())
                    .load(mItem.getLink())
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.image_not_found)
                    .into(mImageView);
        } else {
            Glide.with(getApplicationContext())
                    .load(mImage.getLink())
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.image_not_found)
                    .into(mImageView);
        }

    }

}
