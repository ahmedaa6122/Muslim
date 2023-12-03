package com.example.quran.ui.azkarList;

import android.content.Context;

import com.example.quran.data.azkarProvider.AzkarListProvider;
import com.example.quran.data.pojo.Azkar;
import com.example.quran.data.pojo.ZekrType;

import java.util.ArrayList;

public class AzkarListViewHolder {
    public ArrayList<Azkar> getAzkar(Context context,String zekr,String fileName) {
        return  new AzkarListProvider().getAzkarByType(context,zekr,fileName);
    }
}
