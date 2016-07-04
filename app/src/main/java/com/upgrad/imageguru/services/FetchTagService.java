package com.upgrad.imageguru.services;

import android.content.Context;

import com.upgrad.imageguru.model.ImgurAPI;
import com.upgrad.imageguru.model.tag.TagResponse;
import com.upgrad.imageguru.utils.Constants;
import com.upgrad.imageguru.utils.NetworkUtils;

import java.lang.ref.WeakReference;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * <p/>
 * Our upload service. This creates our restadapter, uploads our image, and notifies us of the response.
 */
public class FetchTagService {
    public final static String TAG = FetchTagService.class.getSimpleName();

    private WeakReference<Context> mContext;

    public FetchTagService(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public void Execute(String title, Callback<TagResponse> callback) {
        final Callback<TagResponse> cb = callback;

        if (!NetworkUtils.isConnected(mContext.get())) {
            //Callback will be called, so we prevent a unnecessary notification
            cb.failure(null);
            return;
        }

        RestAdapter restAdapter = buildRestAdapter();

        restAdapter.create(ImgurAPI.class).fetchTag(
                Constants.getClientAuth(),
                title,
                new Callback<TagResponse>() {
                    @Override
                    public void success(TagResponse tagResponse, Response response) {
                        if (cb != null) cb.success(tagResponse, response);
                        if (response == null) {
                            // TODO: Tag fetch failed
                            return;
                        }
                        /*
                        Notify image was uploaded successfully
                        */
                        if (tagResponse.isSuccess()) {
                            // TODO: Tag successfully fetched
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        if (cb != null) cb.failure(error);
                        // TODO: Tag fetch failed
                    }
                });
    }

    private RestAdapter buildRestAdapter() {
        RestAdapter imgurAdapter = new RestAdapter.Builder()
                .setEndpoint(ImgurAPI.server)
                .build();

        /*
        Set rest adapter logging if we're already logging
        */
        if (Constants.LOGGING)
            imgurAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        return imgurAdapter;
    }
}
