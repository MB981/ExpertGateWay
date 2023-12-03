package com.example.expertgateway.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.expertgateway.Model.HomeModel;
import com.example.expertgateway.databinding.BannerViewBinding;
import com.example.expertgateway.databinding.BannerViewTwoBinding;
import com.example.expertgateway.databinding.ItemAllServicesViewHolderBinding;
import com.example.expertgateway.databinding.ItemIndustriesBinding;
import com.example.expertgateway.databinding.ItemTrendingBinding;

import java.util.List;


public class WhatsNewRecyclerAdapter extends RecyclerView.Adapter {

    //////// Declaration of Lists etc////////
    Activity mContext;
    private List<HomeModel.SectionsDetails> dataList;
    int total_types;

    public static class IndustriesViewHolder extends RecyclerView.ViewHolder {

        ItemIndustriesBinding industriesViewBinding;

        public IndustriesViewHolder(ItemIndustriesBinding industriesViewBinding) {
            super(industriesViewBinding.getRoot());
            this.industriesViewBinding = industriesViewBinding;
        }
    }

    public static class TrendingViewHolder extends RecyclerView.ViewHolder {
        ItemTrendingBinding itemViewTrendingBinding;

        public TrendingViewHolder(ItemTrendingBinding itemViewTrendingBinding) {
            super(itemViewTrendingBinding.getRoot());
            this.itemViewTrendingBinding = itemViewTrendingBinding;
        }
    }

    public static class SliderViewHolder2 extends RecyclerView.ViewHolder {
        BannerViewTwoBinding bannerViewTwoBinding;

        public SliderViewHolder2(BannerViewTwoBinding bannerViewTwoBinding) {
            super(bannerViewTwoBinding.getRoot());
            this.bannerViewTwoBinding = bannerViewTwoBinding;
        }
    }

    public static class SliderViewHolder1 extends RecyclerView.ViewHolder {
        BannerViewBinding bannerViewBinding;

        public SliderViewHolder1(BannerViewBinding bannerViewBinding) {
            super(bannerViewBinding.getRoot());
            this.bannerViewBinding = bannerViewBinding;
        }
    }

    public static class AllServicesViewHolder extends RecyclerView.ViewHolder {
        ItemAllServicesViewHolderBinding itemAllServicesViewHolderBinding;

        public AllServicesViewHolder(ItemAllServicesViewHolderBinding itemAllServicesViewHolderBinding) {
            super(itemAllServicesViewHolderBinding.getRoot());
            this.itemAllServicesViewHolderBinding = itemAllServicesViewHolderBinding;
        }
    }

    public WhatsNewRecyclerAdapter(List<HomeModel.SectionsDetails> data, Activity context) {
        this.dataList = data;
        this.mContext = context;
        total_types = data.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Section.Banner:
                return new SliderViewHolder1(BannerViewBinding.inflate(mContext.getLayoutInflater()));
            case Section.Industries:
                return new IndustriesViewHolder(ItemIndustriesBinding.inflate(mContext.getLayoutInflater()));
            case Section.Banner2:
                return new SliderViewHolder2(BannerViewTwoBinding.inflate(mContext.getLayoutInflater()));
            case Section.Trending:
                return new TrendingViewHolder(ItemTrendingBinding.inflate(mContext.getLayoutInflater()));
            case Section.All_Services:
                return new AllServicesViewHolder(ItemAllServicesViewHolderBinding.inflate(mContext.getLayoutInflater()));
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        switch (dataList.get(position).getName()) {
            case "Banner":
                return Section.Banner;
            case "Industries":
                return Section.Industries;
            case "Banner2":
                return Section.Banner2;

          /*  case "Just for you":
                return Section.Just_for_you;*/
            case "Trending":
                return Section.Trending;
       /*     case "Offers":
                return Section.Offers;*/
            case "All services":
                return Section.All_Services;

            default:
                return 1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        if (holder != null && holder.itemView != null) {
            HomeModel.SectionsDetails home_model = dataList.get(position);

            if (home_model != null) {
                switch (home_model.getName()) {
                    case "Banner":
                        if (dataList.get(position).getSectionnew() != null) {
                            BannerAdapter sliderAdapter = new BannerAdapter(mContext, dataList.get(position).getSectionnew(), ((SliderViewHolder1) holder).bannerViewBinding.sliderViewpagerFragmentHome);
                            ((SliderViewHolder1) holder).bannerViewBinding.sliderViewpagerFragmentHome.setAdapter(sliderAdapter);
                            sliderAdapter.startAutoSlider();
                        }
                        break;

                    case "Industries":
                        if (dataList.get(position).getSectionnew() != null) {
                            ServicesAdapter servicesAdapter;
                            ((IndustriesViewHolder) holder).industriesViewBinding.rvServices.setLayoutManager(
                                    new GridLayoutManager(mContext, 5)); // Set the span count to 5 for 5 columns
                            servicesAdapter = new ServicesAdapter(dataList.get(position).getSectionnew(), mContext);
                            ((IndustriesViewHolder) holder).industriesViewBinding.rvServices.setAdapter(servicesAdapter);
                        }
                        break;

                    case "Banner2":
                        if (dataList.get(position).getSectionnew() != null) {
                            BannerAdapter sliderAdapter2 = new BannerAdapter(mContext, dataList.get(position).getSectionnew(), ((SliderViewHolder2) holder).bannerViewTwoBinding.sliderViewpagerFragmentHome);
                            ((SliderViewHolder2) holder).bannerViewTwoBinding.sliderViewpagerFragmentHome.setAdapter(sliderAdapter2);
                            sliderAdapter2.startAutoSlider();
                        }
                        break;

                    case "Trending":
                        if (dataList.get(position).getSectionnew() != null && !dataList.get(position).getSectionnew().isEmpty()) {
                            TrendingAdapter trendingAdapter;
                            ((TrendingViewHolder) holder).itemViewTrendingBinding.rvTrending.setLayoutManager(
                                    new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
                            trendingAdapter = new TrendingAdapter(mContext, dataList.get(position).getSectionnew());
                            ((TrendingViewHolder) holder).itemViewTrendingBinding.rvTrending.setAdapter(trendingAdapter);
                        } else {
                            ((TrendingViewHolder) holder).itemViewTrendingBinding.tvNoDataFound.setVisibility(View.VISIBLE);
                        }
                        break;

                    case "All services":
                        if (dataList.get(position).getSectionnew() != null) {
                            AllServicesAdapter allServicesAdapter;
                            ((AllServicesViewHolder) holder).itemAllServicesViewHolderBinding.rvServices.setLayoutManager(
                                    new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
                            allServicesAdapter = new AllServicesAdapter(mContext, dataList.get(position).getSectionnew());
                            ((AllServicesViewHolder) holder).itemAllServicesViewHolderBinding.rvServices.setAdapter(allServicesAdapter);
                        }
                        break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }
}