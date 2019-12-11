package com.example.healthguidesystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class workout extends AppCompatActivity {
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);


        final BottomNavigationView bottomnavigationView = findViewById(R.id.navbot);
       next = (Button) findViewById(R.id.next);
       next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(workout.this,food.class));
           }
       });






        bottomnavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){

                    case R.id.nav_home:
                        Toast.makeText(workout.this,"BMI calculator", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(workout.this,BmiCalculator.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_account).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_userinfo).setVisibility(View.GONE);
                        break;

                    case R.id.nav_account:
                        Toast.makeText(workout.this,"Managed Account", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(workout.this,Profile.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_home).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_userinfo).setVisibility(View.GONE);

                        break;

                    case R.id.nav_userinfo:
                        Toast.makeText(workout.this,"Information Page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(workout.this,userinfo.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_home).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_account).setVisibility(View.GONE);
                        break;

                    case R.id.nav_guide:
                        Toast.makeText(workout.this,"Guide Page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(workout.this,workout.class));
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
}
