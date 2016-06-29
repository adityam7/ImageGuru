package com.upgrad.imageguru.services;

import android.content.Context;

import com.upgrad.imageguru.model.GalleryResponse;
import com.upgrad.imageguru.model.ImgurAPI;
import com.upgrad.imageguru.utils.Constants;
import com.upgrad.imageguru.utils.NetworkUtils;

import java.lang.ref.WeakReference;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * <p/>
 * Our upload service. This creates our restadapter, uploads our image, and notifies us of the response.
 */
public class FetchGalleryService {
    public final static String TAG = FetchGalleryService.class.getSimpleName();

    private WeakReference<Context> mContext;

    public FetchGalleryService(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void Execute(String title, Callback<GalleryResponse> callback) {
        final Callback<GalleryResponse> cb = callback;

        if (!NetworkUtils.isConnected(mContext.get())) {
            //Callback will be called, so we prevent a unnecessary notification
            cb.failure(null);
            return;
        }

        RestAdapter restAdapter = buildRestAdapter();

        restAdapter.create(ImgurAPI.class).fetchGallery(
                Constants.getClientAuth(),
                title,
                new Callback<GalleryResponse>() {
                    @Override
                    public void success(GalleryResponse galleryResponse, Response response) {
                        if (cb != null) cb.success(galleryResponse, response);
                        if (response == null) {
                            // TODO: Gallery fetch failed
                            response.toString();
                            return;
                        }
                        /*
                        Notify image was uploaded successfully
                        */
                        if (galleryResponse.isSuccess()) {
                            response.toString();
                            // TODO: Gallery successfully fetched
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        if (cb != null) cb.failure(error);
                        // TODO: Gallery fetch failed
                    }
                });
    }

    private RestAdapter buildRestAdapter() {
        RestAdapter imgurAdapter = new RestAdapter.Builder()
                .setEndpoint(ImgurAPI.server)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addHeader("Authorization", "Client-ID be8c1993e29cbb9");
                    }
                })
                .build();

        /*
        Set rest adapter logging if we're already logging
        */
        if (Constants.LOGGING)
            imgurAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        return imgurAdapter;
    }
}
