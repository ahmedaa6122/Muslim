package com.example.quran.ui.quran.quranPage;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.quran.data.PageManger;

public class QuranViewModel extends AndroidViewModel {

    public QuranViewModel(@NonNull Application application) {

        super(application);
    }
    public Drawable getQuranImageByPageNumber(int pageNum) {
     return PageManger.getQuranImageByPageNumber(getApplication(),pageNum);
    }
}
