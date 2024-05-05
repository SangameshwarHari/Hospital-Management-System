package com.example.hospitalmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class BookAppointment extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    private DatePickerDialog datePickerDialog;
    Button datebutton,timebutton,BookButton;
    private TimePickerDialog timePickerDialog;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        tv=findViewById(R.id.textApptitle);
        ed1=findViewById(R.id.bookUsername);
        ed2=findViewById(R.id.address);
        ed3=findViewById(R.id.Contactnumber);
        ed4=findViewById(R.id.Fees);
        BookButton=findViewById(R.id.buttonbookregister);
        datebutton=findViewById(R.id.buttonAPPdate);
        timebutton=findViewById(R.id.buttonapptime);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it=getIntent();
        String title=it.getStringExtra("tex");
        String fullname=it.getStringExtra("text2");
        String Address=it.getStringExtra("text3");
        String Contactnumber=it.getStringExtra("text4");
        String Fees=it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(Address);
        ed3.setText(Contactnumber);
        ed4.setText("con fees"+Fees);
        initDatePicker();
        datebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
        initTimepicker();
        timebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
        BookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Databasebook db1=new Databasebook(getApplicationContext(),"Book",null,1);
                String name = ed1.getText().toString();
                String address = ed2.getText().toString();
                String contact = ed3.getText().toString();
                String fees = ed4.getText().toString();
                if (name.length() == 0 || address.length() == 0 || contact.length() == 0 || fees.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter valid input", Toast.LENGTH_LONG).show();
                }else{
                    db1.book(name,address,contact,fees);
                    Toast.makeText(getApplicationContext(), "Booked", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                datebutton.setText(i2+"/"+i1+"/"+i);
            }
        };
            Calendar cal=Calendar.getInstance();
            int year=cal.get(Calendar.YEAR);
            int month=cal.get(Calendar.MONTH);
            int day=cal.get(Calendar.DAY_OF_MONTH);
            int style= AlertDialog.THEME_HOLO_DARK;
            datePickerDialog=new DatePickerDialog(this,style,dateSetListener,year,month,day);
            datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }
    private void initTimepicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timebutton.setText(i+":"+i1);

            }
        };
            Calendar cal=Calendar.getInstance();
            int hours=cal.get(Calendar.HOUR);
            int mins=cal.get(Calendar.MINUTE);
            int style=AlertDialog.THEME_HOLO_DARK;
            timePickerDialog= new TimePickerDialog(this,style,timeSetListener,hours,mins,true);
    }
}