package com.example.hospitalmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabtestdetailActivity extends AppCompatActivity {
    TextView tvpackageName,tvTotalcost;
    EditText edDetails;
    Button addtocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labtestdetail);
        tvpackageName=findViewById(R.id.textviewpackageNamee);
        tvTotalcost=findViewById(R.id.textviewtotalcosttt);
        edDetails=findViewById(R.id.editTextMutiLinee);
        addtocart=findViewById(R.id.ADDDtocart);
        edDetails.setKeyListener(null);
        Intent it=getIntent();
        tvpackageName.setText(it.getStringExtra("text1"));
        edDetails.setText(it.getStringExtra("text2"));
        tvTotalcost.setText(it.getStringExtra("text3"));
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences=getSharedPreferences("Shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","".toString());
                String product=tvpackageName.getText().toString();
                float price=Float.parseFloat(getIntent().getStringExtra("text3").toString());
                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                if(db.checkcart(username,product)==1){
                    Toast.makeText(getApplicationContext(), "Product Already Added", Toast.LENGTH_SHORT).show();
                }else{
                    db.addCart(username,product,price,"lab");
                    Toast.makeText(getApplicationContext(), "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabtestdetailActivity.this, Labtestactivity.class));
                }
            }
        });
    }
}