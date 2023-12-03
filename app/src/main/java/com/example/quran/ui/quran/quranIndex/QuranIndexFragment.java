package com.example.quran.ui.quran.quranIndex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.quran.R;
import com.example.quran.animation.MyAnimation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class QuranIndexFragment extends Fragment {
    TabLayout indexTabs;
    ViewPager2 pager;
    QuranIndexPagerAdapter adapter;
    QuranIndexViewModel viewModel;
    ImageButton ref;
    private EditText search;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran_index, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        search=view.findViewById(R.id.quran_search_txt);
        indexTabs = view.findViewById(R.id.quran_index_tabs);
        pager = view.findViewById(R.id.quran_index_pager);
        adapter = new QuranIndexPagerAdapter(this);

        pager.setAdapter(adapter);
       viewModel=new ViewModelProvider(this).get(QuranIndexViewModel.class);
        new TabLayoutMediator(indexTabs, pager,
                (tab, position) -> tab.setText(viewModel.getTabAt(position))
        ).attach();
        search.setOnClickListener(view1 -> {

            NavHostFragment
                    .findNavController(this)
                    .navigate(QuranIndexFragmentDirections
                            .actionQuranIndexFragmentToQuranSearchFragment());
        });
        ref=view.findViewById(R.id.ref);
        ref.setOnClickListener(view1 -> {
            // Retrieving data from SharedPreferences
            SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("my_preferences", Context.MODE_PRIVATE);
            int pageNumber = sharedPreferences.getInt("page number", 0);
            if(pageNumber!=0){
                NavHostFragment
                        .findNavController(this)
                        .navigate(QuranIndexFragmentDirections
                                .actionQuranIndexFragmentToQuranFragment(pageNumber));
            }
        });
    }
}