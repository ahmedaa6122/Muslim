package com.example.quran.ui.quran.quranContainer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quran.ui.quran.quranPage.QuranPageFragment;

public class QuranPageAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 604;

    public QuranPageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }


    @Override
    public Fragment createFragment(int position) {
        return new QuranPageFragment(NUM_PAGES-position);
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
