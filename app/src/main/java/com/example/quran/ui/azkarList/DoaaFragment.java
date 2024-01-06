package com.example.quran.ui.azkarList;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quran.R;
import com.example.quran.data.pojo.Azkar;

import java.util.ArrayList;
import java.util.Collections;

public class DoaaFragment extends Fragment {
    private RecyclerView listAzkar;
    private AzkarListFragmentArgs args;
    private AzkarListAdapter adapter;
    private ViewPager2 viewPager;
    private TextView zekrType;
    private AzkarListViewHolder viewHolder;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args=AzkarListFragmentArgs.fromBundle(requireArguments());
        adapter=new AzkarListAdapter();
        viewHolder=new AzkarListViewHolder();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_azkar_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listAzkar=view.findViewById(R.id.listAzkar);
        zekrType=view.findViewById(R.id.zekrType);
        zekrType.setText(args.getAzkarType());
        ArrayList<Azkar>azkar=viewHolder.getAzkar(getContext(), args.getAzkarType(),"Doaa.json");
        listAzkar.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        listAzkar.setAdapter(adapter);
        adapter.setAzkar(azkar);
    }
}