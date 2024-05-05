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

public class DoctorDetails extends AppCompatActivity {
    Button btn;

    private String[][] doctor_details1=
            {
                    {"Doctor Name:Ajith kumar","Hospital Address:coimbatore","Exp:5 yrs","Mobile No:9677731228","600"},
                    {"Doctor Name:Muralirajan","Hospital Address:sulur","Exp:8 yrs","Mobile No:9677732228","800"},
                    {"Doctor Name:Ashwin","Hospital Address:Ramanathapuram","Exp:3 yrs","Mobile No:9677771228","300"},
                    {"Doctor Name:Ranjith","Hospital Address:Dharapuram","Exp:15 yrs","Mobile No:8677731228","900"},
                    {"Doctor Name:Balaji","Hospital Address:Palladam","Exp:10 yrs","Mobile No:9677731228","1500"}
            };

    private String[][] doctor_details2=
            {
                    {"Doctor Name:Bhuvneshwar kumar","Hospital Address:coimbatore","Exp:5 yrs","Mobile No:9977731228","600"},
                    {"Doctor Name:Murali","Hospital Address:sulur","Exp:8 yrs","Mobile No:9877732228","800"},
                    {"Doctor Name:Ashwin kumar","Hospital Address:Ramanathapuram","Exp:3 yrs","Mobile No:9677771228","300"},
                    {"Doctor Name:Rajan","Hospital Address:Dharapuram","Exp:15 yrs","Mobile No:8677631228","900"},
                    {"Doctor Name:Kholi","Hospital Address:Palladam","Exp:10 yrs","Mobile No:9687731228","1500"}
            };

    private String[][] doctor_details3=
            {
                    {"Doctor Name:kumar","Hospital Address:coimbatore","Exp:5 yrs","Mobile No:8877731228","600"},
                    {"Doctor Name:Raj","Hospital Address:sulur","Exp:8 yrs","Mobile No:9647732228","800"},
                    {"Doctor Name:Ashwath","Hospital Address:Ramanathapuram","Exp:3 yrs","Mobile No:9277771228","300"},
                    {"Doctor Name:Sanjay","Hospital Address:Dharapuram","Exp:15 yrs","Mobile No:8677761228","900"},
                    {"Doctor Name:Sarvesh","Hospital Address:Palladam","Exp:10 yrs","Mobile No:9677731268","1500"}
            };

    private String[][] doctor_details4=
            {
                    {"Doctor Name:Anandh","Hospital Address:coimbatore","Exp:5 yrs","Mobile No:9677731228","600"},
                    {"Doctor Name:Perumal","Hospital Address:sulur","Exp:8 yrs","Mobile No:9677732228","800"},
                    {"Doctor Name:Vishal","Hospital Address:Ramanathapuram","Exp:3 yrs","Mobile No:9677771228","300"},
                    {"Doctor Name:Ravi","Hospital Address:Dharapuram","Exp:15 yrs","Mobile No:8677731228","900"},
                    {"Doctor Name:Chiranjeevi","Hospital Address:Palladam","Exp:10 yrs","Mobile No:9677731228","1500"}
            };


    private String[][] doctor_details5=
            {
                    {"Doctor Name:Bharath","Hospital Address:coimbatore","Exp:5 yrs","Mobile No:9677731228","600"},
                    {"Doctor Name:Siva","Hospital Address:sulur","Exp:8 yrs","Mobile No:9677732228","800"},
                    {"Doctor Name:Jenna","Hospital Address:Ramanathapuram","Exp:3 yrs","Mobile No:9677771228","300"},
                    {"Doctor Name:Watson","Hospital Address:Dharapuram","Exp:15 yrs","Mobile No:8677731228","900"},
                    {"Doctor Name:Rithanya","Hospital Address:Palladam","Exp:10 yrs","Mobile No:9677731228","1500"}
            };
    String[][] doctor_details={};
    ArrayList list;
    SimpleAdapter sa;
    TextView tv;
    HashMap<String,String> item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        btn=findViewById(R.id.button);




        tv=findViewById(R.id.textviewdd);
        Intent intent=getIntent();
        String title=intent.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("family physician")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dieticien")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentists")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;

        else
            if(title.compareTo("Cardiologists")==0)
                doctor_details=doctor_details5;


        list=new ArrayList<>();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons fee: "+doctor_details[i][4]+"/-");
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
                Intent it=new Intent(DoctorDetails.this, BookAppointment.class);
                it.putExtra("tex",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });



    }
}