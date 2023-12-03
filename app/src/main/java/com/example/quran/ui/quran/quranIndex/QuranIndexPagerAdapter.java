package com.example.quran.ui.quran.quranIndex;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quran.data.utils.IndexTabsUtils;
import com.example.quran.ui.quran.soralist.IndexListFragment;

public class QuranIndexPagerAdapter extends FragmentStateAdapter {
    public static final int PAGE_COUNT=2;

    public QuranIndexPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new IndexListFragment(IndexTabsUtils.QuranTabs.SORA);
            case 1:
                return new IndexListFragment(IndexTabsUtils.QuranTabs.JOZZ);
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return PAGE_COUNT;
    }
}
