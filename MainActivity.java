package com.example.jacameq1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //This is where buttons will be created at first
    Button button1; //quarts per day
    Button button2; //ppm calculation
    Button button3; //c1v1 = c2v2 calc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Locate the button on the activitymain.xml using **findViewByID**
        button1 = (Button)findViewById(R.id.quarts_dayBTN); //name of te button at the end
        button2 = findViewById(R.id.ppmBTN);
        button3 = findViewById(R.id.c1BTN);

        //capture button clicks
        button1.setOnClickListener(new View.OnClickListener() { //for quarts per day/////
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, quartsPerDay.class);
                startActivity(myIntent);
            }//onClick brace
        });

        button2.setOnClickListener(new View.OnClickListener() { //for ppm calculation
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ppm_A.class);
                startActivity(myIntent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() { //for ppm calculation
            public void onClick(View v) {
                Intent myIntent2 = new Intent(MainActivity.this, c1v1.class);
                startActivity(myIntent2);
            }
        });






    }//onCreate brace
}//class brace
