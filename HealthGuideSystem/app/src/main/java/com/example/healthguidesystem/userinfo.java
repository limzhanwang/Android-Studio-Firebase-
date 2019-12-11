package com.example.healthguidesystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userinfo extends AppCompatActivity {
    private TextView nameview, ageview, genderview,weightview, heightview, bmiview;
    private Button show;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);


        final BottomNavigationView bottomnavigationView = findViewById(R.id.navbot);

        bmiview = (TextView) findViewById(R.id.resultbmi);
        nameview = (TextView) findViewById(R.id.name);
        ageview = (TextView) findViewById(R.id.age);
        genderview = (TextView) findViewById(R.id.gender);
        weightview = (TextView) findViewById(R.id.weight);
        heightview = (TextView) findViewById(R.id.height);
        show = (Button) findViewById(R.id.show);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userinfo1();
                userinfo2();

            }
        });

        bottomnavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){

                    case R.id.nav_home:
                        Toast.makeText(userinfo.this,"BMI calculator", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(userinfo.this,BmiCalculator.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_account).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_userinfo).setVisibility(View.GONE);
                        break;

                    case R.id.nav_account:
                        Toast.makeText(userinfo.this,"Managed Account", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(userinfo.this,Profile.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_home).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_userinfo).setVisibility(View.GONE);

                        break;

                    case R.id.nav_userinfo:
                        Toast.makeText(userinfo.this,"Information Page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(userinfo.this,userinfo.class));
                        finish();
                        bottomnavigationView.findViewById(R.id.nav_guide).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_home).setVisibility(View.GONE);
                        bottomnavigationView.findViewById(R.id.nav_account).setVisibility(View.GONE);
                        break;

                    case R.id.nav_guide:
                        Toast.makeText(userinfo.this,"Guide Page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(userinfo.this,workout.class));
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

    private void userinfo2() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User Information").child("User BMI details");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String bmicheck=dataSnapshot.child("userbmi").getValue().toString();
                String height=dataSnapshot.child("userheight").getValue().toString();
                String weight=dataSnapshot.child("userweight").getValue().toString();
                heightview.setText(height);
                weightview.setText(weight);
                bmiview.setText(bmicheck);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });

    }

    private void userinfo1() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User Information").child("User Details");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String name=dataSnapshot.child("name").getValue().toString();
                String age=dataSnapshot.child("userage").getValue().toString();
                String gender=dataSnapshot.child("usergender").getValue().toString();
                nameview.setText(name);
                ageview.setText(age);
                genderview.setText(gender);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });







    }


}
