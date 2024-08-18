package com.example.mybmi1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView FinRes;
        EditText InpHeiIn, InpHeiFeet, InpWeight;
        Button BtnCal;
        LinearLayout Mainlay;


        InpWeight = findViewById(R.id.InpWeight);
        InpHeiFeet = findViewById(R.id.InpHeiFeet);
        InpHeiIn= findViewById(R.id.InpHeiIn);
        FinRes = findViewById(R.id.FinRes);
        BtnCal = findViewById(R.id.BtnCal);
        Mainlay = findViewById(R.id.Mainlay);


        BtnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int feet = Integer.parseInt( InpHeiFeet.getText().toString());
                int inch = Integer.parseInt(InpHeiIn.getText().toString());
                int weight = Integer.parseInt(InpWeight.getText().toString());

                int totalIn = feet*12 + inch;
                double TotalCm = totalIn * 2.53;

                double totalM = TotalCm/100;

                double Bmi = weight/(totalM*totalM);


                if(Bmi>25){
                    FinRes.setText("You are Over Weight ");
                    Mainlay.setBackgroundColor(getColor(R.color.OverWeight));

                } else if (Bmi<18) {
                    FinRes.setText("You are under Weight");
                    Mainlay.setBackgroundColor(getColor(R.color.UnderWeight));

                }
                else {
                    FinRes.setText("You are Normal");
                    Mainlay.setBackgroundColor(getColor(R.color.Normal));

                }



            }
        });


    }
}