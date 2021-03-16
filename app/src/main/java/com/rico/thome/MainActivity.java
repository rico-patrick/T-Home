package com.rico.thome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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


        //database
        database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true);


        //get data from Firebase
        myRef1 = database.getReference("LIGHT1_STATUS");
        myRef2 = database.getReference("LIGHT2_STATUS");
        myRef3 = database.getReference("LIGHT3_STATUS");
        myRef4 = database.getReference("LIGHT4_STATUS");

        getData();

        btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    btn1.setBackgroundColor(getResources().getColor(R.color.btn));
                    myRef1.setValue("ON");
                } else {
                    // The toggle is disabled
                    btn1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    myRef1.setValue("OFF");
                }
            }
        });
        btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    btn2.setBackgroundColor(getResources().getColor(R.color.btn));
                    myRef2.setValue("ON");
                } else {
                    // The toggle is disabled
                    btn2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    myRef2.setValue("OFF");
                }
            }
        });
        btn3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    btn3.setBackgroundColor(getResources().getColor(R.color.btn));
                    myRef3.setValue("ON");

                } else {
                    // The toggle is disabled
                    btn3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    myRef3.setValue("OFF");
                }
            }
        });
        btn4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    btn4.setBackgroundColor(getResources().getColor(R.color.btn));
                    myRef4.setValue("ON");

                } else {
                    // The toggle is disabled
                    btn4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    myRef4.setValue("OFF");
                }
            }
        });

    }

    private void getData() {

        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value1 = snapshot.getValue(String.class);
                if (value1.equals("ON")) {
                    System.out.println(value1 + "1");
                    btn1.setChecked(true);
                }else{
                    btn1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Error in Retrieving Data", Toast.LENGTH_SHORT).show();
            }
        });


        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value2 = snapshot.getValue(String.class);
                if (value2.equals("ON")) {
                    System.out.println(value2 + "2");
                    btn2.setChecked(true);
                }else {
                    btn2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Error in Retrieving Data", Toast.LENGTH_SHORT).show();
            }
        });

        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value3 = snapshot.getValue(String.class);
                if (value3.equals("ON")) {
                    System.out.println(value3 + "3");
                    btn3.setChecked(true);
                }else {
                    btn3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Error in Retrieving Data", Toast.LENGTH_SHORT).show();
            }
        });

        myRef4.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value4 = snapshot.getValue(String.class);
                if (value4.equals("ON")) {
                    System.out.println(value4 + "4");
                    btn4.setChecked(true);
                }else{
                    btn4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Error in Retrieving Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}