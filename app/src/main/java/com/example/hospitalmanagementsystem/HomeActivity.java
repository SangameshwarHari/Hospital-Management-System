package com.example.hospitalmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CardView exit = findViewById(R.id.cardexit);



        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs",MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");
        Toast.makeText(getApplicationContext(), "welcome"+username, Toast.LENGTH_LONG).show();

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent intent=new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        CardView finddoctor=findViewById(R.id.cardfinddoctors);
        finddoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,find_doctor.class);
                startActivity(intent);
            }
        });

        CardView labtest=findViewById(R.id.labtest);
        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this, Labtestactivity.class);
                startActivity(intent);
            }
        });

        CardView buymedicine=findViewById(R.id.cardmedicines);
        buymedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this, Buymedicineactivityy.class);
                startActivity(intent);
            }
        });
        CardView homearticleactivity=findViewById(R.id.cardhealthdoctor);
        homearticleactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,Homeartcileactivity.class);
                startActivity(intent);
            }
        });



    }
}