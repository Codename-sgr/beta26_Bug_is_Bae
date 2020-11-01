package com.bugisbae.bloodhive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawer;
    ImageButton myFeed,myAccount,Donate;


    CardView bloodACV,bloodBCV,bloodABCV,bloodOCV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("BloodHive");


        }

        Donate=findViewById(R.id.newAdButton);
        myFeed=findViewById(R.id.myFeed);
        bloodABCV=findViewById(R.id.bloodAB);
        bloodACV=findViewById(R.id.bloodA);
        bloodBCV=findViewById(R.id.bloodB);
        bloodOCV=findViewById(R.id.bloodO);

        Donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UserHealth.class));
            }
        });

        selectCategiry();


    }

    private void selectCategiry() {
        final Intent intent = new Intent(getApplicationContext(), ListDonor.class);
        bloodACV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("bloodGrp", "A");
                startActivity(intent);
            }
        });
        bloodBCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("bloodGrp", "B");
                startActivity(intent);
            }
        });
        bloodABCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("bloodGrp", "AB");
                startActivity(intent);
            }
        });
        bloodOCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("bloodGrp", "O");
                startActivity(intent);
            }
        });
    }


}
