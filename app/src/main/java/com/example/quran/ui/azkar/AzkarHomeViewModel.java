package com.example.quran.ui.azkar;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.quran.data.azkarProvider.AzkarListProvider;
import com.example.quran.data.pojo.ZekrType;
import com.example.quran.ui.quran.quranSearch.QuranSearchAdapter;

import java.util.ArrayList;
import java.util.HashSet;

public class AzkarHomeViewModel extends ViewModel {


    HashSet<ZekrType> getAzkar(Context context,String fileName){
        return AzkarListProvider.getAzkarTypes(context,fileName);
    }
}
