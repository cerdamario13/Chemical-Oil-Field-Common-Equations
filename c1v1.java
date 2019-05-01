package com.example.jacameq1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

//////////////////////////   In this activity, everything is related to the #3
public class c1v1 extends AppCompatActivity {

    //declaring the variables that are needed
    EditText c1, v1; //for the inputs
    TextView v2, v2_2; //for the outputs
    Button btnClear, btnCalc;
    Switch switch13;

    double c1_num;
    double v1_num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1v1);

        //First get the variables form the xml to java using 'findVewById'
        //inputs
        c1 = findViewById(R.id.ppm3_input);
        v1 = findViewById(R.id.v13_input);

        //results
        v2 = findViewById(R.id.v2Micro_output);//for micro Liters
        v2_2 = findViewById(R.id.v2Mili_output); //for mili Liters

        //buttons
        btnCalc = findViewById(R.id.calc3_button);
        btnClear = findViewById(R.id.clear3_button);

        //Switches
        switch13 = findViewById(R.id.switch1);

        //Set up the disable button
        c1.addTextChangedListener(loginTextWatcher);
        v1.addTextChangedListener(loginTextWatcher);

        //setting the cleat button to clear all entries
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear the entries
                c1.getText().clear();
                v1.getText().clear();

                //clearing the results
                TextView v2 = findViewById(R.id.v2Micro_output); v2.setText(null);
                TextView v2_2 = findViewById(R.id.v2Mili_output); v2_2.setText(null);
            }
        });



        //calculate button set up
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double concentration = 1000000; //for c1 aka concentration
                c1_num = Double.parseDouble((c1.getText().toString()));
                v1_num = Double.parseDouble((v1.getText().toString()));

                switch13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked) {
                            // do something, the isChecked will be
                            // true if the switch is in the On position
                            double concentration = 1000000; //for c1 aka concentration
                            //calculation for result
                            double v2_num = (c1_num * (v1_num / 0.264172)) / concentration;
                            //display the result
                            v2.setText(Double.toString(Math.round(v2_num * 1000000)));//for micro liters

                            double v2_num2 = (((c1_num * (v1_num/ 0.264172) ) / concentration) * 1000000) / 1000;
                            v2_2.setText(Double.toString((v2_num2)));//milli liters

                        } else { // if not checked
                            // do something, the isChecked will be
                            // true if the switch is in the On position
                            double concentration = 1000000; //for c1 aka concentration
                            //calculation for result
                            double v2_num = (c1_num * v1_num) / concentration;
                            //display the result
                            v2.setText(Double.toString(Math.round(v2_num * 1000000)));//for micro liters

                            double v2_num2 = (((c1_num * v1_num) / concentration) * 1000000) / 1000;
                            v2_2.setText(Double.toString((v2_num2)));//milli liters
                        }
                    }
                });
            }
        });



    }//onCreate brace

    //Disable the calc button until both fields have an input
    private TextWatcher loginTextWatcher = new TextWatcher() { // set up for the enable and disable
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override  //Only care about this once in this case
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String c1_input = c1.getText().toString().trim();
            String v1_input = v1.getText().toString().trim();

            btnCalc.setEnabled(!c1_input.equals("") && !v1_input.equals(""));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}//class brace
