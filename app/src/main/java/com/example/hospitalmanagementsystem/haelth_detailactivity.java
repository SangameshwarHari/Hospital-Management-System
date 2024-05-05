package com.example.hospitalmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class haelth_detailactivity extends AppCompatActivity {
    TextView tv1;
    ImageView img;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haelth_detailactivity);
        btnback=findViewById(R.id.backbuttonhadd);
        tv1=findViewById(R.id.textviewdefhadd);
        img=findViewById(R.id.imagehadd);

        Intent it=getIntent();
        tv1.setText(it.getStringExtra("text1"));

        Bundle bundle=getIntent().getExtras();
        if(bundle != null){
            int resId = bundle.getInt("text2");
            img.setImageResource(resId);
        }
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(haelth_detailactivity.this,Homeartcileactivity.class));
            }
        });
    }
}