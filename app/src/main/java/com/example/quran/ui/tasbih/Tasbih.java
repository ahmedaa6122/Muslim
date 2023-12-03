package com.example.quran.ui.tasbih;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.quran.R;
import com.example.quran.animation.MyAnimation;

public class Tasbih extends Fragment {
    private ProgressBar progressBar;
    private TextView progressText;
    int count = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasbih, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RelativeLayout layoutToAnimate = view.findViewById(R.id.progress_layout);
        MyAnimation animation=new MyAnimation(layoutToAnimate,0.8f);
        animation.animation();
        progressBar = view.findViewById(R.id.progress_bar);
        progressText = view.findViewById(R.id.progress_text);
        progressBar.setOnClickListener(view1 -> {
            if(count>33) {
                count = 0;
                progressBar.setProgress(0);
            }
            progressText.setText("" + count);
            progressBar.setProgress(count);
            count++;
        });
    }
}