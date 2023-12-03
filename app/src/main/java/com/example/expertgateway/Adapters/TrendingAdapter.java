package com.example.expertgateway.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.expertgateway.Model.HomeModel;
import com.example.expertgateway.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {
    private Context context;
    private List<HomeModel.Sectionnew> data;

    public TrendingAdapter(Context context, List<HomeModel.Sectionnew> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public TrendingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trending_rv, parent, false);
        return new TrendingAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingAdapter.ViewHolder holder, int position) {
        HomeModel.Sectionnew services = data.get(position);
        if (services.getAttachments() != null && !services.getAttachments().isEmpty()) {
            // Assuming getAttachments() returns a list and it is not null
            List<HomeModel.Attachments> attachments = services.getAttachments();

            // Load the placeholder initially


            if (attachments != null && !attachments.isEmpty()) {
                // Iterate through all attachments and load their images
                for (int i = 0; i < attachments.size(); i++) {
                    String imageUrl = attachments.get(i).getImageUrl();
                    Glide.with(context)
                            .load(imageUrl)
                            .apply(RequestOptions.skipMemoryCacheOf(false))
                            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA))
                            .apply(RequestOptions.centerCropTransform())
                            .into(holder.ivImage);
                }
            } else {
//                Glide.with(context)
//                        .load(R.drawable.placeholder_drawable)
//                        .apply(RequestOptions.skipMemoryCacheOf(false))
//                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA))
//                        .apply(RequestOptions.centerCropTransform())
//                        .into(holder.ivImage);
            }

            holder.tvTitle.setText(services.getServiceName());
            holder.tvSummary.setText(services.getShortDesc());

        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView cvCardMain;
        TextView tvTitle;
        TextView tvSummary;
        TextView tvBookNow;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvCardMain = itemView.findViewById(R.id.cvCardMain);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSummary = itemView.findViewById(R.id.tvSummary);
            tvBookNow = itemView.findViewById(R.id.tvBookNow);
            ivImage = itemView.findViewById(R.id.ivImage);
        }
    }
}
