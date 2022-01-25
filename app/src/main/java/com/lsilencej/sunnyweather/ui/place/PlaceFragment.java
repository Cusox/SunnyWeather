package com.lsilencej.sunnyweather.ui.place;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lsilencej.sunnyweather.R;
import com.lsilencej.sunnyweather.logic.model.PlaceResponse;

public class PlaceFragment extends Fragment {

    public PlaceViewModel placeViewModel;
    private PlaceAdapter placeAdapter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place, container, false);
        placeViewModel = new ViewModelProvider(this).get(PlaceViewModel.class);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        EditText searchPlaceEdit = (EditText) view.findViewById(R.id.searchPlaceEdit);
        ImageView bgImageView = (ImageView) view.findViewById(R.id.bgImageView);
        recyclerView.setLayoutManager(layoutManager);
        placeAdapter = new PlaceAdapter(this, placeViewModel.getPlaceList());
        recyclerView.setAdapter(placeAdapter);
        searchPlaceEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String content = editable.toString();
                if (!content.isEmpty()) {
                    placeViewModel.searchPlaces(content);
                } else {
                    recyclerView.setVisibility(View.GONE);
                    bgImageView.setVisibility(View.VISIBLE);
                    placeViewModel.getPlaceList().clear();
                    placeAdapter.notifyDataSetChanged();
                }
            }
        });
        placeViewModel.getPlaceLiveData().observe(this, new Observer<PlaceResponse>() {
            @Override
            public void onChanged(PlaceResponse placeResponse) {
                if (placeResponse.getStatus().equals("ok")) {
                    recyclerView.setVisibility(View.VISIBLE);
                    bgImageView.setVisibility(View.GONE);
                    placeViewModel.getPlaceList().clear();
                    placeViewModel.getPlaceList().addAll(placeResponse.getPlaces());
                    placeAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getActivity(), "未能查询到任何地点", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
