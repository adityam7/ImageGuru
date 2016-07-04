package com.upgrad.imageguru.model;

import com.upgrad.imageguru.model.gallery.GalleryResponse;
import com.upgrad.imageguru.model.tag.TagResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;

/**
 * This is our imgur API. It generates a rest API via Retrofit from Square inc.
 * <p/>
 * more here: http://square.github.io/retrofit/
 */
public interface ImgurAPI {
    String server = "https://api.imgur.com";

    /**
     * Fetch Tag
     *
     * @param auth #Type of authorization for upload
     * @param tag  #Tag to search for
     * @param cb   Callback used for success/failures
     */
    @GET("/3/gallery/t/{tag}")
    void fetchTag(
            @Header("Authorization") String auth,
            @Path("tag") String tag,
            Callback<TagResponse> cb
    );

    /**
     * Fetch Gallery
     *
     * @param auth #Type of authorization for upload
     * @param id   #ID of gallery
     * @param cb   Callback used for success/failures
     */
    @GET("/3/gallery/album/{id}")
    void fetchGallery(
            @Header("Authorization") String auth,
            @Path("id") String id,
            Callback<GalleryResponse> cb
    );
}