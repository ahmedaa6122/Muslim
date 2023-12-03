package com.example.quran.ui.quran.quranSearch;

import android.content.Context;

import com.example.quran.data.database.QuranDao;
import com.example.quran.data.database.QuranDatabase;
import com.example.quran.data.pojo.Aya;

import java.util.ArrayList;

public class QuranSearchViewModel {
    public ArrayList<Aya>getSearchResult(Context context,String keyword) {
        QuranDao dao = QuranDatabase.getInstance(context).quranDao();
        return (ArrayList<Aya>) dao.getAyaByText(keyword);
    }
}
