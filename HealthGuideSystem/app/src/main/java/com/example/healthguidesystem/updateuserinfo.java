package com.example.healthguidesystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class updateuserinfo extends AppCompatActivity {
    private EditText name, userage;
    private AutoCompleteTextView usergender;
    private    static final String[] genderlist = new String[]{"Men","Women"};
    private Button update;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateuserinfo);


        final BottomNavigationView bottomnavigationView = findViewById(R.id.navbot);
        name = (EditText) findViewById(R.id.name);

        usergender = (AutoCompleteTextView) findViewById(R.id.gender);
        userage = (EditText) findViewById(R.id.age);
        update = (Button) findViewById(R.id.update);
        databaseReference = FirebaseDatabase.getInstance().getReference("User Information");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateuser();
            }

        });

        AutoCompleteTextView usergender = findViewById(R.id.gender);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(updateuserinfo.this, android.R.layout.simple_list_item_1,genderlist);
        usergender.setAdapter(adapter);

        bottomnavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){

                    case R.id.nav_home:
                        Toast.makeText(updateuserinfo.this,"BMI calculator", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(updateuserinfo.this,BmiCalculator.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_account).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_userinfo).setVisibility(View.GONE);
                        break;

                    case R.id.nav_account:
                        Toast.makeText(updateuserinfo.this,"Managed Account", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(updateuserinfo.this,Profile.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_home).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_userinfo).setVisibility(View.GONE);

                        break;

                    case R.id.nav_userinfo:
                        Toast.makeText(updateuserinfo.this,"Information Page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(updateuserinfo.this,userinfo.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_home).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_account).setVisibility(View.GONE);
                        break;

                    case R.id.nav_guide:
                        Toast.makeText(updateuserinfo.this,"Guide Page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(updateuserinfo.this,workout.class));
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

    public void updateuser(){
        String username = name.getText().toString();
        String userage1 = userage.getText().toString();
        String usergender1 = usergender.getText().toString();


        status status = new status(username, userage1, usergender1);
        databaseReference.child("User Details").setValue(status);
    }




}
