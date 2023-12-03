package com.example.quran.ui.quran.soralist;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.quran.R;
import com.example.quran.data.utils.IndexTabsUtils;
import com.example.quran.ui.quran.quranIndex.QuranIndexFragmentDirections;
import com.example.quran.ui.quran.quranPage.QuranPageFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class IndexListFragment extends Fragment {
     RecyclerView recyclerView;
     IndexListViewModel viewModel;
     IndexTabsUtils.QuranTabs currentTab;
    public IndexListFragment(IndexTabsUtils.QuranTabs currentTab) {
        this.currentTab = currentTab;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sora_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel=new ViewModelProvider(this).get(IndexListViewModel.class);
        recyclerView=view.findViewById(R.id.soraRecycle);
        recyclerView
                .addItemDecoration(new DividerItemDecoration(
                        getContext()
                        ,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(
                new IndexListAdapter(viewModel
                        .provideIndexList(currentTab),this));


    }





}