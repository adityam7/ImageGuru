package com.upgrad.imageguru.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.upgrad.imageguru.R;
import com.upgrad.imageguru.model.gallery.GalleryImage;
import com.upgrad.imageguru.utils.Helper;

import java.util.List;

/**
 * Created by rachitgoyal on 6/29/16.
 */
public class GalleryRecyclerViewAdapter extends RecyclerView.Adapter<GalleryRecyclerViewAdapter.ImagesViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(GalleryImage image);
    }

    private Context mContext;
    private List<GalleryImage> mGalleryImageList;
    private final OnItemClickListener mListener;

    public class ImagesViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView image;

        public ImagesViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            image = (ImageView) view.findViewById(R.id.image);
        }

        public void bind(final GalleryImage image, final OnItemClickListener listener) {
            Glide.with(mContext)
                    .load(Helper.generateURL(image))
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.image_not_found)
                    .into(this.image);
            title.setText(image.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(image);
                }
            });
        }
    }

    public GalleryRecyclerViewAdapter(Context context, List<GalleryImage> galleryImageList, OnItemClickListener listener) {
        this.mContext = context;
        this.mGalleryImageList = galleryImageList;
        this.mListener = listener;
    }

    @Override
    public ImagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_list_row, parent, false);

        return new ImagesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ImagesViewHolder holder, int position) {
        holder.bind(mGalleryImageList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mGalleryImageList.size();
    }
}