package com.example.quran.ui.azkar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.example.quran.R;
import com.example.quran.animation.MyAnimation;
import com.example.quran.data.pojo.Azkar;
import com.example.quran.data.pojo.ZekrType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class AzkarHomeFragment extends Fragment {

    private RecyclerView azkarList;
    private AzkarHomeAdapter adapter;
    private AzkarHomeViewModel azkarHomeViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new AzkarHomeAdapter(this,"Azkar");
        azkarHomeViewModel = new ViewModelProvider(this).get(AzkarHomeViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_azkar_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        azkarList = view.findViewById(R.id.azkar_recycle);
        azkarList.setAdapter(adapter);
        azkarList.setLayoutManager(new LinearLayoutManager(getContext()));
        HashSet<ZekrType> zekrTypes=azkarHomeViewModel.getAzkar(getContext(),"aazkar.json");

        adapter.setZekrTypes(azkarHomeViewModel.getAzkar(getContext(),"aazkar.json"));
    }
}