package com.example.quran.ui.links;

import com.example.quran.R;
import com.example.quran.data.pojo.Video;

import java.util.ArrayList;

public class VideoLinksViewModel {
    public ArrayList<Video>getData(){
     ArrayList<Video>videos=new ArrayList<>();
     videos.add(new Video(R.drawable.ay_almoshkla
             , "بودكاست اي المشكله"
             ,R.drawable.ay_almoshkla_icon
             ,"https://www.youtube.com/@Eh_El_Moshkla"));
     videos.add(new Video(R.drawable.waay_img,
             "بودكاست وعي",
             R.drawable.waay_icon,
             "https://www.youtube.com/playlist?list=PLCpK4282MCT-lBXi4Nodjzq1TDZsK9qwr"));

        videos.add(new Video(R.drawable.sera,
                "السيره النبويه",
                R.drawable.sera_icon,
                "https://www.youtube.com/playlist?list=PLSSxr3Rf2_X2oKwiy4UhzIdj4ACzB6dee"));

        videos.add(new Video(R.drawable.ala_img,
                "القصص النبوي ( دورة علمني رسول الله",
                R.drawable.ala_icon,
                "https://www.youtube.com/playlist?list=PL1i_D1Vw3d5MtZyd56B0IRjyEPCCHs1zd"));
        videos.add(new Video(R.drawable.magals,
                "مجالس القرءان",
                R.drawable.sera_icon,
                "https://www.youtube.com/playlist?list=PLSSxr3Rf2_X0LhahU5RFyX87dKBAjIkZj"));


        videos.add(new Video(R.drawable.fngan,
                "بودكاست كيف تبجح العلاقات",
                R.drawable.fangan_icon,
                "https://www.youtube.com/watch?v=pJ0auP7dbcY"));


        return  videos;
    }
}
