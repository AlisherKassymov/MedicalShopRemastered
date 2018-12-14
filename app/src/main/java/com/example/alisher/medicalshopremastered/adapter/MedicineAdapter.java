package com.example.alisher.medicalshopremastered.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.alisher.medicalshopremastered.R;
import com.example.alisher.medicalshopremastered.enitity.Medicine;


public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MyViewHolder> {
    private Medicine[] itemsData;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public TextView textView1,textView2;
        public MyViewHolder(View view){
            super(view);

            cardView=(CardView) view.findViewById(R.id.medicine_card_view);
            textView1=(TextView) view.findViewById(R.id.medicineName);
            textView2=(TextView) view.findViewById(R.id.medicinePrice);
        }
    }

    public MedicineAdapter(Medicine[] itemsData){
        this.itemsData=itemsData;
    }


    @Override
    public MedicineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_card,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position){
        holder.textView1.setText(itemsData[position].getName());
        holder.textView2.setText(itemsData[position].getPrice());
    }

    @Override
    public int getItemCount(){
        return itemsData.length;
    }
}
