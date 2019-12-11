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

public class food extends AppCompatActivity {
private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(food.this,workout.class));
                finish();;
            }
        });
        final BottomNavigationView bottomnavigationView = findViewById(R.id.navbot);
        bottomnavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){

                    case R.id.nav_home:
                        Toast.makeText(food.this,"BMI calculator", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(food.this,BmiCalculator.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_account).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_userinfo).setVisibility(View.GONE);
                        break;

                    case R.id.nav_account:
                        Toast.makeText(food.this,"Managed Account", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(food.this,Profile.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_home).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_userinfo).setVisibility(View.GONE);

                        break;

                    case R.id.nav_userinfo:
                        Toast.makeText(food.this,"Information Page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(food.this,userinfo.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_home).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_account).setVisibility(View.GONE);
                        break;

                    case R.id.nav_guide:
                        Toast.makeText(food.this,"Guide Page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(food.this,workout.class));
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
