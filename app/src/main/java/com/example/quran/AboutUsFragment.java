package com.example.quran;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class AboutUsFragment extends Fragment {
ImageButton linkedin,facebook;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linkedin=view.findViewById(R.id.linkedin);
        facebook=view.findViewById(R.id.facebook);
        linkedin.setOnClickListener(item->{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/abdulrahman-saad-617aa8222"));
            if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                getContext().startActivity(intent);
            }

        });
        facebook.setOnClickListener(item->{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100011208606409&mibextid=ZbWKwL"));
            if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                getContext().startActivity(intent);
            }
        });
    }
}