package com.example.expertgateway.FragmentsModule;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;

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
        getHome();
        return view;
    }

    public void getHome() {


/*// used to freeze the touch when progress is loading
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);*/

// sending data to the API
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
                            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            if (keyModel.getMessage() == "success") {

                            } else {


                            }
                        }
                    });
                } else {

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
//                            progress.setVisibility(View.GONE);
                            Snackbar.make(getActivity().findViewById(android.R.id.content),
                                    "Data is null", Snackbar.LENGTH_LONG).show();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<HomeModel> call, Throwable t) {
                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
//                        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
//                        progress.setVisibility(View.GONE);
                        Snackbar.make(getActivity().findViewById(android.R.id.content),
                                "Response Failed", Snackbar.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}