package com.upgrad.imageguru.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.upgrad.imageguru.R;
import com.upgrad.imageguru.model.tag.TagItem;
import com.upgrad.imageguru.utils.Helper;

import java.util.List;

/**
 * Created by rachitgoyal on 6/29/16.
 */
public class TagRecyclerViewAdapter extends RecyclerView.Adapter<TagRecyclerViewAdapter.TagViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(TagItem item);
    }

    private Context mContext;
    private List<TagItem> mTagItemList;
    private final OnItemClickListener mListener;

    public class TagViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView image;
        public LinearLayout tagDescLL;

        public TagViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            image = (ImageView) view.findViewById(R.id.image);
            tagDescLL = (LinearLayout) view.findViewById(R.id.tag_desc_ll);
        }

        public void bind(final TagItem item, final OnItemClickListener listener) {
            Glide.with(mContext)
                    .load(Helper.generateURL(item))
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.image_not_found)
                    .into(image);
            if (item.is_album()) {
                tagDescLL.setBackground(ContextCompat.getDrawable(mContext, R.drawable.gallery_desc_shape));
            } else {
                tagDescLL.setBackground(ContextCompat.getDrawable(mContext, R.drawable.image_desc_shape));
            }
            title.setText(item.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public TagRecyclerViewAdapter(Context context, List<TagItem> tagItemList, OnItemClickListener listener) {
        this.mContext = context;
        this.mTagItemList = tagItemList;
        this.mListener = listener;
    }

    @Override
    public TagViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tag_list_row, parent, false);

        return new TagViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TagViewHolder holder, int position) {
        holder.bind(mTagItemList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mTagItemList.size();
    }
}