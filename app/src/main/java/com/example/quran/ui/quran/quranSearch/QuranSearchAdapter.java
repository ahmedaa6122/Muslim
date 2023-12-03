package com.example.quran.ui.quran.quranSearch;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quran.R;
import com.example.quran.data.pojo.Aya;

import java.util.ArrayList;

public class QuranSearchAdapter extends RecyclerView.Adapter<QuranSearchAdapter.ViewModel> {

    private ArrayList<Aya>ayat;
    private Fragment fragment;
    public String[]colors={"#FCFCFC","#F4F4F4"};

    public QuranSearchAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    public void setAyat(ArrayList<Aya> ayat) {
        this.ayat = ayat;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewModel(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_quran_search,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
        holder.itemView.setBackgroundColor(Color.parseColor(colors[position%2]));
        holder.bind(ayat.get(position));
    }

    @Override
    public int getItemCount() {
        return ayat==null?0:ayat.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder{
        TextView soraNum,soraName,ayaNum,ayaContent;
        public ViewModel(@NonNull View itemView) {
            super(itemView);
            //soraNum=itemView.findViewById(R.id.sora_num);
            soraName=itemView.findViewById(R.id.sora_name);
            ayaNum=itemView.findViewById(R.id.aya_num);
            ayaContent=itemView.findViewById(R.id.aya_content);
        }

        public void bind(Aya aya) {
            //soraNum.setText(String.valueOf(aya.getSora()));
            soraName.setText(String.valueOf(aya.getSora_name_ar()));
            ayaNum.setText(String.valueOf(aya.getAya_no()));
            ayaContent.setText(String.valueOf(aya.getAya_text()));
            itemView.setOnClickListener(view -> {
                closeKeyboard(itemView);
                NavHostFragment.findNavController(fragment).navigate(QuranSearchFragmentDirections.actionQuranSearchFragmentToQuranFragment(aya.getPage()));

            });

        }
    }
    public void closeKeyboard(View item){
        InputMethodManager inputMethodManager = (InputMethodManager) item.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
