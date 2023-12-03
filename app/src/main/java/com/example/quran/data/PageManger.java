package com.example.quran.data;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class PageManger {

    public static Drawable getQuranImageByPageNumber(Context context, int pageNum){
        DecimalFormat formatter = new DecimalFormat("000");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        formatter.setDecimalFormatSymbols(symbols);
        String drawableName = "images/page" + formatter.format(pageNum) + ".png";

        InputStream istr = null;
        try {
            istr = context.getAssets().open(drawableName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Drawable.createFromStream(istr, null);

    }

}
