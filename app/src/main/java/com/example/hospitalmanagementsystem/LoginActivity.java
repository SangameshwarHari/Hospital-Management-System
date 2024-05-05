package com.example.hospitalmanagementsystem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class LoginActivity extends AppCompatActivity {
    EditText loginuser,loginpassword;
    TextView registernew;
    Button Loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginuser=findViewById(R.id.LoginUsername);
        loginpassword=findViewById(R.id.LoginPassword);
        Loginbtn=findViewById(R.id.buttonlogin);
        registernew=findViewById(R.id.Register);
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String user = loginuser.getText().toString();
                String password = loginpassword.getText().toString();
                Database db = new Database(getApplicationContext(), "HealthCare", null, 1);
                Intent intttt=new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intttt);
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter valid input", Toast.LENGTH_LONG).show();
                } else {
                    if (db.login(user, password) == 1) {
                        Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_LONG).show();
                        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        Intent inttttt=new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(inttttt);
                        editor.putString("username",user);
                        editor.apply();
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        registernew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}