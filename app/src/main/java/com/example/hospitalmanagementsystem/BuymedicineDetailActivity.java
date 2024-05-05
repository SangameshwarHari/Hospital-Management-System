package com.example.hospitalmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BuymedicineDetailActivity extends AppCompatActivity {
    TextView packagee,Toatalcost;
    EditText edDeatailss;
    Button btnback,btnaddtocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buymedicine_detail);
        packagee=findViewById(R.id.textviewpackageNameebmd);
        edDeatailss=findViewById(R.id.editTextMutiLineebmd);
        Toatalcost=findViewById(R.id.textviewtotalcostttbmd);
        Intent it=getIntent();
        String packagename=it.getStringExtra("text1");
        String costt=it.getStringExtra("text3");
        String edDetailss=it.getStringExtra("text2");
        btnback=findViewById(R.id.backbuttonBmd);
        btnaddtocart=findViewById(R.id.ADDDtocartbmd);
        packagee.setText(packagename);
        Toatalcost.setText(costt);
        edDeatailss.setText(edDetailss);
        edDeatailss=findViewById(R.id.editTextMutiLineebmd);
        Toatalcost=findViewById(R.id.textviewtotalcostttbmd);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuymedicineDetailActivity.this, Buymedicineactivityy.class));
            }
        });

    }
}