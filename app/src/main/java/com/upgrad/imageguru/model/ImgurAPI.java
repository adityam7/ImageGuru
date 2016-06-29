package com.upgrad.imageguru.model;

import com.upgrad.imageguru.model.GalleryResponse;

import retrofit.Callback;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * This is our imgur API. It generates a rest API via Retrofit from Square inc.
 * <p/>
 * more here: http://square.github.io/retrofit/
 */
public interface ImgurAPI {
    String server = "https://api.imgur.com";

    /** Fetch Gallery
     * @param auth #Type of authorization for upload
     * @param id   #ID of gallery
     * @param cb   Callback used for success/failures
     */
    @POST("/3/gallery/album/")
    void fetchGallery(
            @Header("Authorization") String auth,
            @Query("id") String id,
            Callback<GalleryResponse> cb
    );
}
