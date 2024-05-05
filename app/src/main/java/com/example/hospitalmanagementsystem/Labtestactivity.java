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

public class Labtestactivity extends AppCompatActivity {
    private String[][] packages = {
            {"Package 1:Full Body Checkup","","","","999"},
            {"Package 2:Blood Glucose Fasting","","","","299"},
            {"Package 3:Covid-19 Antibody - TgG","","","","899"},
            {"Package 4:Thyroid Check","","","","499"},
            {"Package 5:Immunity Check","","","","699"}

    };
    private String[] package_details={
            "Blood Glucose Fasting\n"+
                    "Complete Hemogram\n"+
                    "HbAlc\n"+
                    "Iron Studies\n"+
                    "Kidney Function Test\n"+"Liver Function test",

        "Blood Glucose Fasting\n",
                "Covid 19 Antibody","Thyroidprofile-Total","complete-Hemogram"

    };
    HashMap<String,String> item;
    SimpleAdapter sa;
    ArrayList list;
    Button btnGotoCart,btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labtestactivity);
        btnGotoCart=findViewById(R.id.Gotocart);
        btnBack=findViewById(R.id.backbutton);
        lst=findViewById(R.id.listviewww);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Labtestactivity.this,HomeActivity.class));
            }
        });


        btnGotoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Labtestactivity.this, CartLabActivity.class));
            }
        });
        list=new ArrayList<>();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", packages[i][0]);
            item.put( "line2", packages[i][1]);
            item.put( "line3", packages[i][2]);
            item.put( "line4", packages[i][3]);
            item.put( "line5", "Cons fee: "+packages[i][4]+"/-");
            list.add( item );
        }

        sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.listviewww);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(Labtestactivity.this, LabtestdetailActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });


    }
}