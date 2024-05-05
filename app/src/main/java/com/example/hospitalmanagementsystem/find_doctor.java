package com.example.hospitalmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class find_doctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView back=findViewById(R.id.backexit);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(find_doctor.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        CardView familyphy=findViewById(R.id.familyphysicianssss);
        familyphy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(find_doctor.this,DoctorDetails.class);
                intent.putExtra("title","family physician");
                startActivity(intent);
            }
        });

        CardView Buymedicines=findViewById(R.id.Dietician);
        Buymedicines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(find_doctor.this,DoctorDetails.class);
                intent.putExtra("title","Dieticien");
                startActivity(intent);
            }
        });

        CardView dentists=findViewById(R.id.dentists);
        dentists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(find_doctor.this,DoctorDetails.class);
                intent.putExtra("title","Dentists");
                startActivity(intent);
            }
        });

        CardView surgeon=findViewById(R.id.cardsuregion);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(find_doctor.this,DoctorDetails.class);
                intent.putExtra("title","Surgeon");
                startActivity(intent);
            }
        });

        CardView cardiologist=findViewById(R.id.Cardioligigist);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(find_doctor.this,DoctorDetails.class);
                intent.putExtra("title","Cardiologists");
                startActivity(intent);
            }
        });


    }
}