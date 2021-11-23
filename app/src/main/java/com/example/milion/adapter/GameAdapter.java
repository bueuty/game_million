package com.example.milion.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.milion.R;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends ArrayAdapter<String> {

    Context mct;
    ArrayList<String> arr;
    int viObjectGame = 1;


    public GameAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.mct = context;
        this.arr = new ArrayList<>(objects);
    }

    public void setViObjectGame(int viObjectGame) {
        this.viObjectGame = viObjectGame;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)mct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_code,null);
        }
        if(arr.size()> 0){
            int pos  = 15 -position;
            TextView txtCount = convertView.findViewById(R.id.txtCount);
            if(pos %5 == 0){
                txtCount.setTextColor(Color.parseColor("#FFFFFF"));
            }else {
                txtCount.setTextColor(Color.parseColor("#9C27B0"));
            }
            String aboutTrang;
            if(pos/10>0){
                aboutTrang = "   ";
            }else{
                aboutTrang = "     ";
            }
          //  int vitr1 = position + 1;
            String textHienThi = pos+ aboutTrang+"$"+arr.get(position);
            txtCount.setText(textHienThi);

            if(position == viObjectGame){
                txtCount.setBackgroundResource(R.color.black);
            }else {
                txtCount.setBackgroundColor(Color.parseColor("#ACE1CD"));
            }
        }
        return convertView;
    }
}
