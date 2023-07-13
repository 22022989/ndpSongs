package com.example.ndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button btnInsert, btnShowList;

    EditText ed1, ed2, ed3;

    RadioGroup rdGrp;

    ArrayList<String> strList;


    int rating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);

        //ddSpn = findViewById(R.id.spinner);
        //lvResults = findViewById(R.id.lv);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        rdGrp = findViewById(R.id.rdGrp);

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        rdGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radio1){
                    rating = 1;
                }else if(checkedId == R.id.radio2){
                    rating = 2;
                }else if(checkedId == R.id.radio3){
                    rating = 3;
                }else if(checkedId == R.id.radio4){
                    rating = 4;
                } else if (checkedId == R.id.radio5) {
                    rating = 5;
                }
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                db.insertSong(ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString(), rating);
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                startActivity(intent);
            }
        });


    }
}