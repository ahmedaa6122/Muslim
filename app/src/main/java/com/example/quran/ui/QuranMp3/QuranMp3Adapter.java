package com.example.quran.ui.QuranMp3;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quran.R;
import com.example.quran.data.pojo.Sora;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class QuranMp3Adapter extends RecyclerView.Adapter<QuranMp3Adapter.ViewHolder> {
    List<Sora>sora;
    Fragment fragment;
    private MediaPlayer mediaPlayer;
    int currentPlayingPosition=-1;
    public String[]colors={"#FCFCFC","#F4F4F4"};

    public QuranMp3Adapter(List<Sora> sora, Fragment fragment) {
        this.sora = sora;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quran_mp3_item,parent,false));
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setBackgroundColor(Color.parseColor(colors[position%2]));
        holder.bind(sora.get(position));

        DecimalFormat formatter = new DecimalFormat("000");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        formatter.setDecimalFormatSymbols(symbols);
        int pos=position;
        // Check if the current item is the one being played
        if (position == currentPlayingPosition) {
                holder.play.setVisibility(View.GONE);
                holder.pause.setVisibility(View.VISIBLE);
        }else {
            holder.play.setVisibility(View.VISIBLE);
            holder.pause.setVisibility(View.GONE);
        }
        holder.pause.setOnClickListener(view -> {
            mediaPlayer.pause();
            holder.play.setVisibility(View.VISIBLE);
            holder.pause.setVisibility(View.GONE);
        });

        holder.itemView.setOnClickListener(view -> {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFCED0D3"));
            //mediaPlayer.pause();
           if (isNetworkConnected(holder.itemView.getContext())) {
                // Stop the previously playing MediaPlayer, if any
                if (currentPlayingPosition!=-1&&currentPlayingPosition!=pos) {
                        stopMediaPlayer();
                        // Update the previous item's UI
                    notifyItemChanged(currentPlayingPosition);
                }
                if(currentPlayingPosition==pos){
                    if(mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        holder.play.setVisibility(View.VISIBLE);
                        holder.pause.setVisibility(View.GONE);
                    }
                    else{
                        mediaPlayer.start();
                        holder.play.setVisibility(View.GONE);
                        holder.pause.setVisibility(View.VISIBLE);
                    }
                }else {
                    String url = "https://server8.mp3quran.net/afs/"
                            + formatter.format(pos + 1) + ".mp3";

                    currentPlayingPosition = pos; // Update the current playing position
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(url);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                        // Update the UI of the clicked item
                        holder.play.setVisibility(View.GONE);
                        holder.pause.setVisibility(View.VISIBLE);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(holder.itemView.getContext(), "exeption", Toast.LENGTH_SHORT).show();
                    }
                }
           }else
               Toast.makeText(holder.itemView.getContext(),
                       "No Internet Connection",
                       Toast.LENGTH_LONG).show();
            });

    }


    // Method to stop the MediaPlayer
    private void stopMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;

        }
    }
@Override
    public int getItemCount() {
        return sora.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView soraName;
        ImageView play,pause;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            soraName=itemView.findViewById(R.id.sora_name);
            play=itemView.findViewById(R.id.play);
            pause=itemView.findViewById(R.id.pause);
        }

        public void bind(Sora sora) {
            soraName.setText(sora.getArabicName());

        }
    }


    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }
}
