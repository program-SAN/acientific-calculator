package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText weg,heg;
        TextView enter,cal;
        Button btnres,btnreset;

        weg=(EditText) findViewById(R.id.weg);
        heg=(EditText) findViewById(R.id.heg);

        enter=(TextView) findViewById(R.id.enter);
        cal=(TextView) findViewById(R.id.cal);

        btnres=(Button) findViewById(R.id.btnres);
        btnreset=(Button) findViewById(R.id.btnreset);

        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strweg = weg.getText().toString();
                String strheg = heg.getText().toString();

                if (strweg.equals("")){
                    weg.setError("ENTER UR WEIGHT");
                    weg.requestFocus();
                    return;
                }
                if (strheg.equals("")){
                    heg.setError("ENTER UR WEIGHT");
                    heg.requestFocus();
                    return;
                }
                float weight = Float.parseFloat(strweg);
                float height = Float.parseFloat(strheg)/100;

                float bmivalue=bmicalculator(weight,height);

                enter.setText(interpreteBMI(bmivalue));
                cal.setText("BMI= "+bmivalue);
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heg.setText("");
                weg.setText("");
                enter.setText("");
                cal.setText("");
            }
        });

    }
    public float bmicalculator(float weight,float height){
        return weight/(height*height);
    }
    public String interpreteBMI(float bmivalue){
        if (bmivalue<16){
            return "severly underweight";
        }else if (bmivalue<18.5){
            return "underweight";
        }else if (bmivalue<25){
            return "normal";
        }else if (bmivalue<30){
            return "overweight";
        }else{
            return "obese";
        }
    }
}