package com.example.hospitalmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Homeartcileactivity extends AppCompatActivity {
    private String[][] Health_Details=
            {
                    {"Walking Daily", "", "", "", "Click more details"},
                    {"Homecare of COVID 19", "", "", "", "Click more details"},
                    {"Stop Smoking", "", "", "", "Click more details"},
                    {"Menstrual Cramps", "", "", "", "Click more details"},
                    {"Healthy Gut", "", "", "", "Click more details"}

    };
    private int[] images ={
            R.drawable.health1,R.drawable.health2,
            R.drawable.health3,R.drawable.health4,R.drawable.health5


    };
    HashMap<String,String> item;
    SimpleAdapter sa;
    ArrayList list;
    Button btnGotoCart,btnBack;
    ListView lst;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeartcileactivity);
        Button btnBack=findViewById(R.id.backbuttonhad);
        ListView lst=findViewById(R.id.listviewhad);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homeartcileactivity.this,HomeActivity.class));
            }
        });
        list=new ArrayList<>();
        for(int i=0;i<Health_Details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", Health_Details[i][0]);
            item.put( "line2",Health_Details[i][1]);
            item.put( "line3", Health_Details[i][2]);
            item.put( "line4", Health_Details[i][3]);
            item.put( "line5", Health_Details[i][4]);
            list.add( item );
        }

        sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(Homeartcileactivity.this, haelth_detailactivity.class);
                it.putExtra("text1",Health_Details[i][0]);
                it.putExtra("text2",images[i]);
                startActivity(it);
            }
        });

    }

}