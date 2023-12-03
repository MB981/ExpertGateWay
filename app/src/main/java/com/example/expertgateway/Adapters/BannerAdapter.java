package com.example.expertgateway.Adapters;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.expertgateway.Model.HomeModel;
import com.example.expertgateway.R;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends PagerAdapter {
    private Context context;
    private List<HomeModel.Sectionnew> bannersSliderModels;
    private LayoutInflater layoutInflater;
    private ViewPager viewPager;
    private Handler autoSliderHandler;
    private static final long AUTO_SLIDE_DELAY = 3000; // 3 seconds delay between slides

    public BannerAdapter(Context context, List<HomeModel.Sectionnew> bannersSliderModels, ViewPager sliderViewpagerFragmentHome) {
        this.context = context;
        this.bannersSliderModels = bannersSliderModels;
        this.viewPager = sliderViewpagerFragmentHome;
    }

    @Override
    public int getCount() {
        return bannersSliderModels.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.slider_layout_banner, container, false);

        // SET CUSTOM IMAGE HERE
        ImageView imageView = view.findViewById(R.id.imgView);

        // Assuming getAttachments() returns a list and it is not null
        List<HomeModel.Attachments> attachments = bannersSliderModels.get(position).getAttachments();

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
                        .into(imageView);
            }
        }else {
            Glide.with(context)
                    .load(R.drawable.placeholder_drawable)
                    .apply(RequestOptions.skipMemoryCacheOf(false))
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA))
                    .apply(RequestOptions.centerCropTransform())
                    .into(imageView);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

    public void startAutoSlider() {
        if (autoSliderHandler == null) {
            autoSliderHandler = new Handler(Looper.getMainLooper());
            autoSliderHandler.postDelayed(autoSliderRunnable, AUTO_SLIDE_DELAY);
        }
    }

    public void stopAutoSlider() {
        if (autoSliderHandler != null) {
            autoSliderHandler.removeCallbacks(autoSliderRunnable);
            autoSliderHandler = null;
        }
    }

    private Runnable autoSliderRunnable = new Runnable() {
        @Override
        public void run() {
            int nextSlide = viewPager.getCurrentItem() + 1;
            if (nextSlide >= getCount()) {
                nextSlide = 0;
            }

            viewPager.setCurrentItem(nextSlide, true);

            autoSliderHandler.postDelayed(this, AUTO_SLIDE_DELAY);
        }
    };
}
