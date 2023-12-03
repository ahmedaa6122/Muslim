package com.example.quran.ui.QuranMp3;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.quran.data.database.QuranDao;
import com.example.quran.data.database.QuranDatabase;
import com.example.quran.data.pojo.Sora;

import java.util.ArrayList;

public class quranViewModel  extends AndroidViewModel {
    public quranViewModel(@NonNull Application application) {
        super(application);
    }

    public ArrayList<Sora> getAllSoras(){
        QuranDao dao= QuranDatabase.getInstance(getApplication()).quranDao();
        ArrayList<Sora>soras=new ArrayList<>();
        for (int i = 1; i <= 114; i++) {
            soras.add(dao.getSoraByNumber(i));
        }
        return soras;
    }
}
