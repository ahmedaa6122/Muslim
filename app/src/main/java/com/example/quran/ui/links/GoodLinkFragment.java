package com.example.quran.ui.links;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.quran.R;
import com.example.quran.animation.MyAnimation;
import com.example.quran.data.pojo.Video;

import java.util.ArrayList;


public class GoodLinkFragment extends Fragment {
private RecyclerView videoRecycle;
private VideoLinksViewModel viewModel;
private LinksAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel=new VideoLinksViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_good_link, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        videoRecycle=view.findViewById(R.id.links_list);
        ArrayList<Video>videos=viewModel.getData();
        adapter=new LinksAdapter(videos,getContext());
        LinearLayout layoutToAnimate = view.findViewById(R.id.videos);
        MyAnimation animation=new MyAnimation(layoutToAnimate,0.2f);
        animation.animation();
        videoRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        videoRecycle.setAdapter(adapter);
    }
}