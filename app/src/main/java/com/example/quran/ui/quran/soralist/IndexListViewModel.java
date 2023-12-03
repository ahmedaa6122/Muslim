package com.example.quran.ui.quran.soralist;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.quran.data.database.QuranDao;
import com.example.quran.data.database.QuranDatabase;
import com.example.quran.data.pojo.Jozz;
import com.example.quran.data.pojo.Sora;
import com.example.quran.data.utils.IndexTabsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IndexListViewModel extends AndroidViewModel {
    public IndexListViewModel(@NonNull Application application) {
        super(application);
    }

    public ArrayList<Sora>getAllSoras(){
        QuranDao dao= QuranDatabase.getInstance(getApplication()).quranDao();
        ArrayList<Sora>soras=new ArrayList<>();
        for (int i = 1; i <= 114; i++) {
            soras.add(dao.getSoraByNumber(i));
        }
        return soras;
    }

    public ArrayList<Jozz>getAllAjzaa(){
        ArrayList<Jozz>jozzes=new ArrayList<>();
        QuranDao dao= QuranDatabase.getInstance(getApplication()).quranDao();
        for (int i = 1; i <= 30; i++) {
            jozzes.add(dao.getJozzByNumber(i));
        }
        return jozzes;
    }

   

    public List<?> provideIndexList(@NonNull IndexTabsUtils.QuranTabs currentTab) {
        switch (currentTab) {
            case SORA:
                return getAllSoras();
            case JOZZ:
                return getAllAjzaa();
            default:
                return null;
        }
    }

}
