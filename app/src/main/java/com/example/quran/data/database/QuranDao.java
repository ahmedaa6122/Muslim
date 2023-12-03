package com.example.quran.data.database;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.quran.data.pojo.Jozz;
import com.example.quran.data.pojo.Sora;
import com.example.quran.data.pojo.Aya;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface QuranDao {

    @Query("SELECT * FROM quran where page=:page")
    List<Aya>getAyatByPage(int page);


    @Query("SELECT sora as soraNumber, Min(page) as startPage, Max(page) as endPage, sora_name_ar as arabicName, sora_name_en as englishName FROM quran WHERE sora=:soraNumber")
    Sora getSoraByNumber(int soraNumber);

    @Query("SELECT  jozz as jozzNumber ,Min(page) as startPage,Max(page) as endPage  FROM quran WHERE jozz=:jozzNumber")
    Jozz getJozzByNumber(int jozzNumber);
    @Query("SELECT * FROM quran WHERE aya_text_emlaey LIKE '%'|| :keyword || '%'")
    List<Aya> getAyaByText(String keyword);
}
