package com.example.quran.ui.quran.quranSearch;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.quran.R;
import com.example.quran.data.pojo.Aya;

import java.util.ArrayList;

public class QuranSearchFragment extends Fragment {
    private QuranSearchAdapter adapter;
    private RecyclerView quranRecycle;
    private EditText quranSearch;
    private QuranSearchViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter=new QuranSearchAdapter(this);
        viewModel=new QuranSearchViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return LayoutInflater.from(getContext()).inflate(R.layout.fragment_quran_search,container,false);

     }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quranRecycle=view.findViewById(R.id.quran_search_recycle);
        quranSearch=view.findViewById(R.id.quran_search_txt);
        quranSearch.requestFocus();
        showKeyboard();
        quranRecycle.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        quranRecycle.setAdapter(adapter);
        quranSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ArrayList<Aya>ayat=viewModel.getSearchResult(getContext(),charSequence.toString());
                adapter.setAyat(ayat);
             }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    void showKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
}