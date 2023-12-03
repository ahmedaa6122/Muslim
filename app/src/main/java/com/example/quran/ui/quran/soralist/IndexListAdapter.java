package com.example.quran.ui.quran.soralist;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quran.R;
import com.example.quran.data.pojo.Jozz;
import com.example.quran.data.pojo.Sora;
import com.example.quran.ui.quran.quranIndex.QuranIndexFragmentDirections;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class IndexListAdapter extends RecyclerView.Adapter<IndexListAdapter.ViewHolder> {
    List<?>list;
    Fragment fragment;
    public String[]colors={"#FCFCFC","#F4F4F4"};

    public IndexListAdapter(List<?> list, Fragment fragment) {
        this.list = list;
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sora_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setBackgroundColor(Color.parseColor(colors[position%2]));
        if(list.get(position) instanceof Sora)
            holder.bind((Sora) list.get(position));
        else if(list.get(position) instanceof Jozz)
            holder.bind((Jozz)list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView soraName,soraNumber, from, to,wordTo,wordFrom;
        ImageView img;
        TextView soraKeyword;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            soraName = itemView.findViewById(R.id.sora_name);
            soraNumber = itemView.findViewById(R.id.sora_number);
            from = itemView.findViewById(R.id.from);
            to = itemView.findViewById(R.id.to);
            wordTo=itemView.findViewById(R.id.wordTo);
            wordFrom=itemView.findViewById(R.id.word_from);
            img=itemView.findViewById(R.id.imageView2);
            soraKeyword=itemView.findViewById(R.id.sora);
        }

        public void bind(Sora sora) {
            NumberFormat nf= NumberFormat.getInstance(new Locale("ar","EG"));
            wordTo.setVisibility(View.VISIBLE);
            soraNumber.setText((nf.format(sora.getSoraNumber())));
            //soraNumber.setText(String.valueOf(nf.format(sora.getSoraNumber()))+"\u06DD");
            soraName.setText(sora.getArabicName());
            from.setText(nf.format(sora.getStartPage()));
            to.setText(nf.format(sora.getEndPage()));
            itemView.setOnClickListener(v -> NavHostFragment
                    .findNavController(fragment)
                    .navigate(QuranIndexFragmentDirections.actionQuranIndexFragmentToQuranFragment(sora.getStartPage())));
        }

        public void bind(Jozz jozz) {
            NumberFormat nf= NumberFormat.getInstance(new Locale("ar","EG"));
            img.setVisibility(View.GONE);
            soraName.setText((fragment.getString(R.string.jozz)+": "+(nf.format(jozz.getJozzNumber()))));
            wordTo.setVisibility(View.VISIBLE);
            soraKeyword.setVisibility(View.GONE);
            soraNumber.setText("");
            from.setText(nf.format(jozz.getStartPage()));
            to.setText(nf.format(jozz.getEndPage()));

            itemView.setOnClickListener(v -> NavHostFragment
                    .findNavController(fragment)
                    .navigate(QuranIndexFragmentDirections.actionQuranIndexFragmentToQuranFragment(jozz.getStartPage())));
        }
    }
}
