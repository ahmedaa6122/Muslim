package com.example.quran.ui.QuranMp3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.example.quran.R;
import com.example.quran.animation.MyAnimation;


public class QuranMp3 extends Fragment {
RecyclerView soraRecycle;
quranViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran_mp3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        soraRecycle=view.findViewById(R.id.soraRecycle);
        soraRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel=new ViewModelProvider(this).get(quranViewModel.class);
        soraRecycle.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        soraRecycle.setAdapter(new QuranMp3Adapter(viewModel.getAllSoras(),this));
        //LinearLayout layoutToAnimate = view.findViewById(R.id.soralayout);
        //MyAnimation animation=new MyAnimation(layoutToAnimate,0.1f);
        //animation.animation();

    }
}