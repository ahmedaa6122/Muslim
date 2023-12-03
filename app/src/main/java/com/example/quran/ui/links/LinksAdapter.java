package com.example.quran.ui.links;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quran.R;
import com.example.quran.data.pojo.Video;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LinksAdapter extends RecyclerView.Adapter<LinksAdapter.ViewHolder> {
    ArrayList<Video>videos;
    Context context;

    public LinksAdapter(ArrayList<Video> videos, Context context) {
        this.videos = videos;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.bind(videos.get(position));
      holder.itemView.setOnClickListener(view -> {
          Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videos.get(position).getLink()));
          if (intent.resolveActivity(context.getPackageManager()) != null) {
              context.startActivity(intent);
          }

      });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mainImg,channelImg;
        TextView videoName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainImg=itemView.findViewById(R.id.main_img);
            channelImg=itemView.findViewById(R.id.channel_img);
            videoName=itemView.findViewById(R.id.video_name);
        }

        public void bind(Video video) {
            mainImg.setImageResource(video.getVideoThumbnail());
            channelImg.setImageResource(video.getChannelImg());
            videoName.setText(video.getVideoName());
        }
    }
}
