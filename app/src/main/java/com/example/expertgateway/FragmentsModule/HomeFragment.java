package com.example.expertgateway.FragmentsModule;

import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.expertgateway.Adapters.BannerAdapter;
import com.example.expertgateway.Adapters.WhatsNewRecyclerAdapter;
import com.example.expertgateway.Helper.ApiClient;
import com.example.expertgateway.Helper.ApiService;
import com.example.expertgateway.Model.HomeModel;
import com.example.expertgateway.R;
import com.example.expertgateway.databinding.FragmentHomeBinding;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    WhatsNewRecyclerAdapter mWhatsNewAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        binding.swSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.swSwipe.setRefreshing(true);

                getHome();

            }
        });
        binding.swSwipe.setColorSchemeResources(R.color.red,
                android.R.color.holo_red_dark,
                android.R.color.holo_blue_dark,
                android.R.color.holo_red_light);
        getHome();
        return view;
    }

    public void getHome() {
        binding.swSwipe.setRefreshing(true);
        startShimmer();
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<HomeModel> call = apiService.getHome();
        call.enqueue(new Callback<HomeModel>() {
            @Override
            public void onResponse(Call<HomeModel> call, Response<HomeModel> response) {

                ///// Progress Dialog  Dismiss////////////

                final HomeModel keyModel = response.body();
                if (keyModel != null) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.swSwipe.setRefreshing(false);
                            stopShimmer();
                            mWhatsNewAdapter = new WhatsNewRecyclerAdapter(keyModel.getResult().getSectionsDetails(), getActivity());
                            binding.newrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                            binding.newrecycler.setAdapter(mWhatsNewAdapter);

                            Glide.with(getActivity())
                                    .load(keyModel.getResult().getSectionsDetails().get(0).getImageUrl())
                                    .into(binding.imgView);

                        }
                    });
                } else {

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.swSwipe.setRefreshing(false);
                            stopShimmer();
                            Toast.makeText(getActivity(), "Data is null", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<HomeModel> call, Throwable t) {
                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
//                        Snackbar.make(getActivity().findViewById(android.R.id.content),
//                                "Response Failed", Snackbar.LENGTH_LONG).show();
                        binding.swSwipe.setRefreshing(false);
                        Toast.makeText(getActivity(), "Response Failed", Toast.LENGTH_SHORT).show();
                        stopShimmer();
                    }
                });
            }
        });
    }

    public void startShimmer() {
        binding.nvScroll.setVisibility(View.GONE);
        binding.rlShimmerView.setVisibility(View.VISIBLE);

    }

    public void stopShimmer() {
        binding.nvScroll.setVisibility(View.VISIBLE);
        binding.rlShimmerView.setVisibility(View.GONE);

    }

/*    public void servicesAdapter(List<HomeModel.Sectionnew> services) {
        // Assuming binding.rlServices is your RecyclerView
        binding.rlServices.setLayoutManager(new GridLayoutManager(getActivity(), 5));
// Set your adapter
        ServicesAdapter servicesAdapter = new ServicesAdapter(services, getActivity());
        binding.rlServices.setAdapter(servicesAdapter);

    }*/
}