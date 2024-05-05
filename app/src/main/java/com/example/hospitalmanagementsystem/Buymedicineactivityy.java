package com.example.hospitalmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Buymedicineactivityy extends AppCompatActivity {
    private String[][] packages={
            {"Uprise-03 1000IU Capsule","","","","50"},
            {"HealthVit Chromium Picolinate 200mcg Capsule","","","","305"},
            {"Vitamin B Complex Capsules","","","","448"},
            {"Inlife Vitamin E Wheat Germ Oil Capsule","","","","539"},
            {"Dolo 650 Tablet","","","","30"},
            {"Crocin 650 Advance Tablet","","","","50"},
            {"Strepsils Medicated Lozenges for sore Throat","","","","40"},
            {"Tata img Calcium + Vitamin D3","","","","30"},
            {"Feronine -XT Tablet","","","","130"},

    };
    private String[] package_details = {
            "Building and keeping the bones &teeth strong\n" +
                    "Reducing Fatigue/stress and muscular pains\n"+
                    "Boosting immunity and increasing resistance against infection\n",
            "Chromium is an essential trace mineral that plays an important role in helping insule",
            "Provides relief from vitamin B deficiencies","It promotes health as well as skin benefit",
            "Helps relieve fever and bring down a high temperature","provides a wars and comforting feeling during sore throat",
            "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"
    };

    ArrayList list;
    SimpleAdapter sa;
    TextView tv;
    HashMap<String,String> item;
    ListView lst;
    Button btnGotoBack,btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buymedicineactivityy);

            lst=findViewById(R.id.lisviewwwBM);
            btnGotoBack=findViewById(R.id.GotocarBM);
            btnback=findViewById(R.id.backbuttonBm);
            btnback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Buymedicineactivityy.this, HomeActivity.class));
                }
            });

            list=new ArrayList();

            for(int i=0;i<packages.length;i++){
                item = new HashMap<String,String>();
                item.put( "line1", packages[i][0]);
                item.put( "line4", packages[i][1]);
                item.put( "line3", packages[i][2]);
                item.put( "line2", packages[i][3]);
                item.put( "line5", packages[i][4]);
                list.add( item );
            }
            sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                    new String[]{"line1","line2","line3","line4","line5"},
                    new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
            lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(Buymedicineactivityy.this, BuymedicineDetailActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });



    }
    }
