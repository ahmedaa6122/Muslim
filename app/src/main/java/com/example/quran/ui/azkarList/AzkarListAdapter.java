package com.example.quran.ui.azkarList;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quran.R;
import com.example.quran.data.pojo.Azkar;
import com.example.quran.data.pojo.ZekrType;
import com.example.quran.ui.azkar.AzkarHomeAdapter;

import java.util.ArrayList;

public class AzkarListAdapter extends RecyclerView.Adapter<AzkarListAdapter.ViewHolder> {


    ArrayList<Azkar> zekrTypes;


    public void setAzkar(ArrayList<Azkar> zekrTypes) {
        this.zekrTypes = zekrTypes;
    }

    @NonNull
    @Override
    public AzkarListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AzkarListAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.doaa_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AzkarListAdapter.ViewHolder holder, int position) {
        holder.bind(zekrTypes.get(position));

        holder.counterNum.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return zekrTypes == null ? 0 : zekrTypes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView zekr,description,count,reference,counterNum;
        //View line;
        ImageView share,copy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            zekr = itemView.findViewById(R.id.zekr);
            counterNum=itemView.findViewById(R.id.counterNum);
            description=itemView.findViewById(R.id.description);
            count=itemView.findViewById(R.id.count);
            reference=itemView.findViewById(R.id.reference);
            //line=itemView.findViewById(R.id.line);
            share=itemView.findViewById(R.id.share);
            copy=itemView.findViewById(R.id.copy);

        }

        public void bind(Azkar azkar) {
            zekr.setText(azkar.getZekr());
            description.setText(azkar.getDescription());
            reference.setText(azkar.getReference());

            if(azkar.getReference().length()==0||azkar.getDescription().length()==0) {
               // line.setVisibility(View.GONE);
                reference.setVisibility(View.GONE);
                description.setVisibility(View.GONE);
            }

            if(azkar.getCount().equals(""))
                count.setText("عدد مرات: 1");
            else
                count.setText("عدد مرات: "+azkar.getCount());

            share.setOnClickListener(view -> {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, azkar.getZekr());

                // Show the system's share sheet
                itemView.getContext().startActivity(Intent.createChooser(shareIntent, "Share using"));
            });
            copy.setOnClickListener(view->{
                // Get the system clipboard manager
                ClipboardManager clipboardManager = (ClipboardManager) itemView.getContext().getSystemService(Context.CLIPBOARD_SERVICE);

                // Create a ClipData object to store the copied text
                android.content.ClipData clipData = android.content.ClipData.newPlainText("Copied Message", azkar.getZekr());

                // Put the ClipData on the clipboard
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(itemView.getContext(), "Message copied to clipboard", Toast.LENGTH_SHORT).show();

            });

        }

    }

}
