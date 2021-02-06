package com.rico.thome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    ToggleButton btn1, btn2, btn3, btn4;
    FirebaseDatabase database;
    DatabaseReference myRef1, myRef2, myRef3, myRef4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.rely1);
        btn2 = findViewById(R.id.rely2);
        btn3 = findViewById(R.id.rely3);
        btn4 = findViewById(R.id.rely4);
        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef1 = database.getReference("LIGHT1_STATUS");
        myRef2 = database.getReference("LIGHT2_STATUS");
        myRef3 = database.getReference("LIGHT3_STATUS");
        myRef4 = database.getReference("LIGHT4_STATUS");


        btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    btn1.setBackgroundColor(getResources().getColor(R.color.btn));
                    myRef1.setValue("ON");
                    Toast.makeText(MainActivity.this, "Rely 1 ON", Toast.LENGTH_SHORT).show();

                } else {
                    // The toggle is disabled
                    btn1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    myRef1.setValue("OFF");
                    Toast.makeText(MainActivity.this, "Rely 1 OFF", Toast.LENGTH_SHORT).show();

                }
            }
        });
        btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    btn2.setBackgroundColor(getResources().getColor(R.color.btn));
                    myRef2.setValue("ON");
                    Toast.makeText(MainActivity.this, "Rely 2 ON", Toast.LENGTH_SHORT).show();

                } else {
                    // The toggle is disabled
                    btn2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    myRef2.setValue("OFF");
                    Toast.makeText(MainActivity.this, "Rely 2 OFF", Toast.LENGTH_SHORT).show();

                }
            }
        });
        btn3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    btn3.setBackgroundColor(getResources().getColor(R.color.btn));
                    myRef3.setValue("ON");
                    Toast.makeText(MainActivity.this, "Rely 3 ON", Toast.LENGTH_SHORT).show();


                } else {
                    // The toggle is disabled
                    btn3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    myRef3.setValue("OFF");
                    Toast.makeText(MainActivity.this, "Rely 3 OFF", Toast.LENGTH_SHORT).show();

                }
            }
        });
        btn4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    btn4.setBackgroundColor(getResources().getColor(R.color.btn));
                    myRef4.setValue("ON");
                    Toast.makeText(MainActivity.this, "Rely 4 ON", Toast.LENGTH_SHORT).show();


                } else {
                    // The toggle is disabled
                    btn4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    myRef4.setValue("OFF");
                    Toast.makeText(MainActivity.this, "Rely 4 OFF", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}