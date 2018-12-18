package com.example.alisher.medicalshopremastered.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.alisher.medicalshopremastered.R;

public class MedicineItemActivity extends AppCompatActivity {
    private static final String NAME="name";
    private static final String DESC="description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_item);


        Intent intent=getIntent();
        String name=intent.getStringExtra(NAME);
        String desc=intent.getStringExtra(DESC);

        TextView textView1=findViewById(R.id.medicineNameClick);
        TextView textView2=findViewById(R.id.medicineDescClick);

        textView1.setText(name);
        textView2.setText(desc);
    }
}
