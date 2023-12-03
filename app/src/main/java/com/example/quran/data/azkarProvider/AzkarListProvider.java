package com.example.quran.data.azkarProvider;

import android.content.Context;
import android.util.Log;

import com.example.quran.data.pojo.Azkar;
import com.example.quran.data.pojo.ZekrType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class AzkarListProvider {
    private static ArrayList<Azkar> getAllAzkar(Context context,String fileName) {
        return readJson(context,fileName);
    }


    public static ArrayList<Azkar>getAzkarByType(Context context,String zekrType,String fileName){
        return getAllAzkar(context,fileName)
                .stream()
                .filter(zekr->zekrType.equals(zekr.getCategory()))
                .collect(Collectors.toCollection(ArrayList::new));
    }



    public static HashSet<ZekrType> getAzkarTypes(Context context,String fileName){
        return getAllAzkar(context,fileName)
                .stream()
                .map(zekr -> new ZekrType(zekr.getCategory()))
                .collect(Collectors.toCollection(HashSet::new));
    }


    private static ArrayList<Azkar> readJson(Context context,String fileName){
        try {
            String filePath="azkar/"+fileName;
            //Log.d("test",filePath);
            InputStream azkarFile = context.getAssets().open(filePath);
            //Log.d("test",filePath);
            int size = azkarFile.available();
            byte[] bytes = new byte[size];
            azkarFile.read(bytes);
            azkarFile.close();
            String azkarString = new String(bytes, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            ArrayList<Azkar> azkar = gson.fromJson(azkarString, new TypeToken<List<Azkar>>() {
            }.getType());
            return azkar;
        } catch (IOException e) {
            //Log.d("test","hear");
            e.printStackTrace();
            return null;
        }
    }
}
