package com.example.healthguidesystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BmiCalculator extends AppCompatActivity {

    private EditText height, weight;
    private TextView result;
    private Button calculate;


    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        final BottomNavigationView bottomnavigationView = findViewById(R.id.navbot);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);
        databaseReference = FirebaseDatabase.getInstance().getReference("User Information");

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
               adduserinformation();






            }
        });

        bottomnavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){

                    case R.id.nav_home:
                        Toast.makeText(BmiCalculator.this,"BMI calculator", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(BmiCalculator.this,BmiCalculator.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_account).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_userinfo).setVisibility(View.GONE);
                        break;

                    case R.id.nav_account:
                        Toast.makeText(BmiCalculator.this,"Managed Account", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(BmiCalculator.this,Profile.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_home).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_userinfo).setVisibility(View.GONE);

                        break;

                    case R.id.nav_userinfo:
                        Toast.makeText(BmiCalculator.this,"Information Page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(BmiCalculator.this,userinfo.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_home).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_account).setVisibility(View.GONE);
                        break;

                    case R.id.nav_guide:
                        Toast.makeText(BmiCalculator.this,"Guide Page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(BmiCalculator.this,workout.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_userinfo).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_home).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_account).setVisibility(View.GONE);
                        break;
                }
                return true;

            }
        });


    }

    public void adduserinformation(){
        String height1 = height.getText().toString();
        String weight1 = weight.getText().toString();
        String result1 = result.getText().toString();


        status2 status = new status2( result1,height1, weight1);
        databaseReference.child("User BMI details").setValue(status);
    }










    public void calculateBMI() {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr)/100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
    }


    private void displayBMI(float bmi) {


        String bmilabel = "";
        if (Float.compare(bmi, 15f) <= 0) {
            bmilabel = getString(R.string.very_severely_under_weight);
        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
            bmilabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
            bmilabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18f) > 0 && Float.compare(bmi, 25f) <= 0) {
            bmilabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
            bmilabel = getString(R.string.overweight);
        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
            bmilabel = getString(R.string.obese_class_i);
        } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
            bmilabel = getString(R.string.obese_class_ii);
        } else {
            bmilabel = getString(R.string.obese_class_iii);
        }

        bmilabel = bmi + "\n\n" + bmilabel;
                result.setText(bmilabel);


    }






}
