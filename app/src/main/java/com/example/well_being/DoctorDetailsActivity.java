package com.example.well_being;

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

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Soroubh Sharma", "Hospital Address : NG1", "Exp : 5yrs", "Mobile No:9898989898", "1,284"},
                    {"Doctor Name : Ashkan Babaei", "Hospital Address : NG2", "Exp : 15yrs", "Mobile No:7898989898", "1,177"},
                    {"Doctor Name : Reza Asadi", "Hospital Address : NG3", "Exp : 8yrs", "Mobile No:8898989898", "1,070"},
                    {"Doctor Name : Mohammad Daneshgar", "Hospital Address : NG4", "Exp : 6yrs", "Mobile No:9898000000", "1,070"},
                    {"Doctor Name : Milad Moghaddam", "Hospital Address : NG5", "Exp : 7yrs", "Mobile No:7798989898", "1,498"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Ali Noori", "Hospital Address : NG6", "Exp : 5yrs", "Mobile No:9898989898", "1,284"},
                    {"Doctor Name : Arash Azizi", "Hospital Address : NG7", "Exp : 15yrs", "Mobile No:7898989898", "1,177"},
                    {"Doctor Name : Zahra Ghobadi", "Hospital Address : NG8", "Exp : 8yrs", "Mobile No:8898989898", "1,070"},
                    {"Doctor Name : Mehrdad Fallah", "Hospital Address : NG9", "Exp : 6yrs", "Mobile No:9898000000", "1,070"},
                    {"Doctor Name : Sohrab Pakzad", "Hospital Address : NG10", "Exp : 7yrs", "Mobile No:7798989898", "1,498"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Mahdi Ghayedi", "Hospital Address : NG11", "Exp : 4yrs", "Mobile No:9898989898", "1,284"},
                    {"Doctor Name : Alireza Ghorbani", "Hospital Address : NG12", "Exp : 5yrs", "Mobile No:7898989898", "1,177"},
                    {"Doctor Name : Hossein Rezaei", "Hospital Address : NG13", "Exp : 7yrs", "Mobile No:8898989898", "1,177"},
                    {"Doctor Name : Sourena Razghandi", "Hospital Address : NG14", "Exp : 6yrs", "Mobile No:9898000000", "1,367"},
                    {"Doctor Name : Dariush Eghbali", "Hospital Address : NG15", "Exp : 7yrs", "Mobile No:7798989898", "1,498"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Kourosh Zarandooz", "Hospital Address : NG16", "Exp : 5yrs", "Mobile No:9898989898", "1,177"},
                    {"Doctor Name : Iman Mahmoudi", "Hospital Address : NG17", "Exp : 15yrs", "Mobile No:7898989898", "1,599"},
                    {"Doctor Name : Niki Karimi", "Hospital Address : NG18", "Exp : 8yrs", "Mobile No:8898989898", "1,070"},
                    {"Doctor Name : Amir Yazdani", "Hospital Address : NG19", "Exp : 6yrs", "Mobile No:9898000000", "1,284"},
                    {"Doctor Name : Saeed Sadeghi", "Hospital Address : NG20", "Exp : 7yrs", "Mobile No:7798989898", "1,498"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Masoud Rigi", "Hospital Address : NG21", "Exp : 5yrs", "Mobile No:9898989898", "1,599"},
                    {"Doctor Name : Milad Sarlak", "Hospital Address : NG22", "Exp : 15yrs", "Mobile No:7898989898", "1,650"},
                    {"Doctor Name : Hamed Lak", "Hospital Address : NG23", "Exp : 8yrs", "Mobile No:8898989898", "1,200"},
                    {"Doctor Name : Mohsen Shekari", "Hospital Address : NG24", "Exp : 6yrs", "Mobile No:9898000000", "1, 400"},
                    {"Doctor Name : Omid Karimi", "Hospital Address : NG25", "Exp : 7yrs", "Mobile No:7798989898", "1,500"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons  Fees:"+"Rs."+doctor_details[i][4]);
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}