package com.example.alisher.medicalshopremastered.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.example.alisher.medicalshopremastered.R;
import com.example.alisher.medicalshopremastered.enitity.Medicine;

import java.util.ArrayList;
import java.util.List;


public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MyViewHolder> implements Filterable {
    private List<Medicine> itemsData;
    private List<Medicine> itemsFilteredData;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public TextView textView1,textView2;
        public View mView;

        public MyViewHolder(View view){
            super(view);
            mView=view;
            cardView=(CardView) view.findViewById(R.id.medicine_card_view);
            textView1=(TextView) view.findViewById(R.id.medicineName);
            textView2=(TextView) view.findViewById(R.id.medicinePrice);
        }
    }

    public MedicineAdapter(List<Medicine> itemsData){
        this.itemsData=itemsData;
        this.itemsFilteredData=itemsData;
    }


    @Override
    public MedicineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_card,parent,false);
        final MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position){
        holder.textView1.setText(itemsData.get(position).getName());
        holder.textView2.setText(itemsData.get(position).getPrice());
    }

    @Override
    public int getItemCount(){
        return itemsFilteredData.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    itemsFilteredData = itemsData;
                } else {
                    List<Medicine> filteredList = new ArrayList<>();
                    for (Medicine row : itemsData) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getPrice().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    itemsFilteredData = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = itemsFilteredData;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                itemsFilteredData = (ArrayList<Medicine>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
