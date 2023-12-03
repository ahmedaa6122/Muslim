package com.example.quran.ui.quran.quranContainer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quran.R;


public class QuranContainerFragment extends Fragment {

    //private static final int NUM_PAGES = 604;
    private ViewPager2 viewPager;
    private QuranContainerFragmentArgs args;

    private FragmentStateAdapter pagerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        args=QuranContainerFragmentArgs.fromBundle(requireArguments());
        return inflater.inflate(R.layout.fragment_quran_container, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.quran_pager);
        viewPager.setAdapter( new QuranPageAdapter(this));
        viewPager.setCurrentItem(604-args.getStartPage(),false);
        // Access the SharedPreferences

    }
    //add last read page to shared preferences
    @Override
    public void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("my_preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("page number", 604-viewPager.getCurrentItem());

        editor.apply();
        //Toast.makeText(getContext(),String.valueOf(viewPager.getCurrentItem()),Toast.LENGTH_LONG).show();
    }
}