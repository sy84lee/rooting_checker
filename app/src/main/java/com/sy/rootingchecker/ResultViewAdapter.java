package com.sy.rootingchecker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultViewAdapter extends RecyclerView.Adapter<ResultViewAdapter.ViewHolder> {

   ArrayList<DetectResult> arr_menu = new ArrayList<DetectResult>();

   public ResultViewAdapter(ArrayList<DetectResult> list){
        this.arr_menu = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.detect_result_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DetectResult result = arr_menu.get(position);
        holder.setItem(result);
    }

    @Override
    public int getItemCount() {
        return arr_menu.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        private TextView item_title;
        private TextView item_result;
        private ImageView item_icon;

        ViewHolder(final View itemView) {
            super(itemView);
            item_title = (TextView) itemView.findViewById(R.id.txt_title);
            item_icon = (ImageView) itemView.findViewById(R.id.detect_icon);
            item_result = (TextView) itemView.findViewById(R.id.txt_result);
        }

        public void setItem(DetectResult result) {
            item_title.setText(result.title);
            if (result.result == ADetectModule.DETECT) {
                item_icon.setImageResource(R.drawable.ic_unsatisfied);
                item_icon.setColorFilter(Color.parseColor("#ef5350"));
                item_result.setText("DETECT!!");
            }
            else {
                item_icon.setImageResource(R.drawable.ic_satisfied);
                item_icon.setColorFilter(Color.parseColor("#555555"));
                item_result.setText("NOT DETECT");
            }
            //
        }
    }
}
