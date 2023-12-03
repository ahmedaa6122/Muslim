package com.example.quran.ui.quran.quranPage;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.quran.R;
import com.example.quran.ui.quran.quranPage.QuranViewModel;

public class QuranPageFragment extends Fragment {

    private ImageView image;
    private QuranViewModel quranViewModel;
    private int pageNumber;

    public QuranPageFragment(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        quranViewModel=new ViewModelProvider(this).get(QuranViewModel.class);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_quran, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        image=view.findViewById(R.id.quranPage);
        Drawable q=quranViewModel.getQuranImageByPageNumber(pageNumber);
        image.setImageDrawable(q);


    }
}