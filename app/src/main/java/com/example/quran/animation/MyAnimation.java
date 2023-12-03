package com.example.quran.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class MyAnimation {
    private View view;
    private float dur;
    public MyAnimation(View view,float dur) {
        this.view=view;
        this.dur=dur;
    }

    public void animation(){
        Animation slideUpAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, dur,
                Animation.RELATIVE_TO_SELF, 0.0f);
        slideUpAnimation.setDuration(700);
        view.startAnimation(slideUpAnimation);
    }
}
