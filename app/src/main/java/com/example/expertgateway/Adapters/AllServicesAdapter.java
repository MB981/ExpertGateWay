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


import java.util.List;

public class AllServicesAdapter extends RecyclerView.Adapter<AllServicesAdapter.ViewHolder> {
    private Context context;
    private List<HomeModel.Sectionnew> data;

    public AllServicesAdapter(Context context, List<HomeModel.Sectionnew> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public AllServicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_services, parent, false);
        return new AllServicesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AllServicesAdapter.ViewHolder holder, int position) {
        HomeModel.Sectionnew services = data.get(position);
        holder.tvName.setText(services.getServiceName());
        if (services.getOfferprice() != null) {
            holder.tvPrice.setText(services.getOfferprice());
        }

        if (data.get(position).getAttachments() != null && !data.get(position).getAttachments().isEmpty()) {
            // Check if the attachments list is not null and not empty
            Glide.with(context)
                    .load(data.get(position).getAttachments().get(0).getImageUrl())
                    .apply(RequestOptions.skipMemoryCacheOf(false))
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA))
                    .apply(RequestOptions.centerCropTransform()).placeholder(R.drawable.card_img)
                    .into(holder.ivImage);
        } else {
            // Handle the case where the attachments list is empty or null
            // You can load a placeholder image or take any appropriate action
            Glide.with(context)
                    .load(R.drawable.card_img)
                    .into(holder.ivImage);
        }

        if (services.getShortDesc() != null) {
            holder.tvDescription.setText(services.getShortDesc());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvName;
        TextView tvDescription;
        TextView tvPrice;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivImage = itemView.findViewById(R.id.ivImage);
        }
    }
}
