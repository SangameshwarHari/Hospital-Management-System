package com.example.hospitalmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText rname, remail, rpass, rconfirm;
    Button regbtn;
    TextView txtlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        rname = findViewById(R.id.RegisterUsername);
        remail = findViewById(R.id.Registeremail);
        rpass = findViewById(R.id.RegisterPassword);
        rconfirm = findViewById(R.id.Confirmpassword);
        regbtn = findViewById(R.id.buttonregister);
        txtlog = findViewById(R.id.Login);


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db=new Database(getApplicationContext(),"HealthCare",null,1);
                String username = rname.getText().toString();
                String useremail = remail.getText().toString();
                String userpassword = rpass.getText().toString();
                String confirmpassword = rconfirm.getText().toString();
                if (username.length() == 0 || useremail.length() == 0 || userpassword.length() == 0 || confirmpassword.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter valid input", Toast.LENGTH_LONG).show();
                } else {
                    if (userpassword.compareTo(confirmpassword) == 0) {
                        if (isValid(userpassword)) {
                            db.register(username,useremail,userpassword);
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_LONG).show();
                            Intent intt = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intt);
                        } else {
                            Toast.makeText(getApplicationContext(), "Password should contain letters,numbers", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "password and confirm password didnt match", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });

        txtlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });


    }

    public static boolean isValid(String password) {
        int f1 = 0, f2 = 0;
        if (password.length() < 4) {
            return false;
        } else {
            for (int p = 0; p < password.length(); p++) {
                if (Character.isLetter(password.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < password.length(); r++) {
                if (Character.isDigit(password.charAt(r))) {
                    f2 = 1;
                }
            }

            if (f1 == 1 & f2 == 1)
                return true;
            return false;

        }
    }

}