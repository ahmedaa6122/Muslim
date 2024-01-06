package com.example.quran.ui.azkar;

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
import com.example.quran.data.pojo.ZekrType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class AzkarHomeAdapter extends RecyclerView.Adapter<AzkarHomeAdapter.ViewHolder> {
   private ArrayList<ZekrType>zekrTypes;
   private Fragment fragment;
    public String[]colors={"#FCFCFC","#F4F4F4"};
    private String fileName;
    public AzkarHomeAdapter(Fragment fragment,String fileName) {
        this.fragment = fragment;
        this.fileName=fileName;
    }

    public void setZekrTypes(HashSet<ZekrType> zekrTypes) {
        this.zekrTypes =new ArrayList<>(zekrTypes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.azkar_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setBackgroundColor(Color.parseColor(colors[position%2]));
        holder.bind(zekrTypes.get(position));
    }

    @Override
    public int getItemCount() {
        return zekrTypes==null?0:zekrTypes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView zekrName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            zekrName=itemView.findViewById(R.id.zekr_name);
        }

        public void bind(ZekrType zekrType) {
            zekrName.setText(zekrType.getZekrName());

            itemView.setOnClickListener(view -> {
                itemView.setBackgroundColor(Color.parseColor("#FFCED0D3"));
                if(fileName.equals("Azkar")) {
                    NavHostFragment
                            .findNavController(fragment)
                            .navigate(AzkarHomeFragmentDirections
                                    .actionAzkarHomeFragmentToAzkarListFragment(zekrType.getZekrName()));
                }else if(fileName.equals("Doaa")){
                    NavHostFragment
                            .findNavController(fragment)
                            .navigate(DoaaHomeFragmentDirections
                                    .actionDoaaHomeFragmentToDoaaFragment(zekrType.getZekrName()));
                }
            });
        }
    }
}
