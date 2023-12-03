package com.example.expertgateway.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.expertgateway.Model.HomeModel;
import com.example.expertgateway.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {

    private List<HomeModel.Sectionnew> data;
    private Context context;

    public ServicesAdapter(List<HomeModel.Sectionnew> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ServicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_services, parent, false);
        return new ServicesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesAdapter.ViewHolder holder, int position) {
        HomeModel.Sectionnew services = data.get(position);
        if (services.getServiceName() != null) {
            holder.tvName.setText(services.getServiceName());
            Log.e("NAME", "onBindViewHolder: " + services.getServiceName());
        }

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
                        .into(holder.imageView);
            }
        }else {
            Glide.with(context)
                    .load(R.drawable.placeholder_drawable)
                    .apply(RequestOptions.skipMemoryCacheOf(false))
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA))
                    .apply(RequestOptions.centerCropTransform())
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cvImage);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
