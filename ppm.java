package com.example.jacameq1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ppm_A extends AppCompatActivity {

    //declaring the variables needed
    EditText bbl, gDay; //for the inputs
    TextView ppm; //for the results
    Button btnCalc, btnClear;

    double bbl_num;
    double gDay_num;

    //two decimal places
    private static DecimalFormat df2 = new DecimalFormat(".##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppm_2);

        //First get the variables from the xml to java using 'findViewById'

        //inputs
        bbl = findViewById(R.id.bbl_2_input);
        gDay = findViewById(R.id.rate_2_input);

        //results
        ppm = findViewById(R.id.ppm_2_input);

        //Buttons
        btnCalc = findViewById(R.id.btn_ppm_calc);
        btnClear = findViewById(R.id.btn_ppm_clear);

        //setting the clear button to clear all entries
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearing the entries
                bbl.getText().clear(); gDay.getText().clear();
                //clearing the result
                TextView dDay = findViewById(R.id.gPerDay_output); gDay.setText(null);
            }//onClick brace
        });

        //calculate button
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double concentration = 1000000; //concentration

                bbl_num = Double.parseDouble(bbl.getText().toString());
                gDay_num = Double.parseDouble(gDay.getText().toString());

                double ppm_num = (concentration / ((bbl_num * 42) * gDay_num));

                //displaying the text
                ppm.setText(Double.toString(Math.round(ppm_num)));

            }//on click brace
        });





    }//onnCreate brace
}//class brace
