package com.example.api_recycler_demo.api.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.api_recycler_demo.R;

public class MainActivity extends AppCompatActivity {

    TextView riskarea_id, habits_id, tests_id, packages_id, disease_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        riskarea_id = findViewById(R.id.riskarea_id);
        habits_id = findViewById(R.id.habits_id);
        tests_id = findViewById(R.id.tests_id);
        packages_id = findViewById(R.id.packages_id);
        disease_id = findViewById(R.id.disease_id);

        setToolbar();


        riskarea_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GetAll_RiskAreas.class);
                startActivity(i);
            }
        });


        tests_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListTest.class);
                startActivity(i);
            }
        });


        habits_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GetAllHabits.class);
                startActivity(i);
            }
        });

        packages_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListPackages.class);
                startActivity(i);
            }
        });

        disease_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GetAllDisease.class);
                startActivity(i);
            }
        });

    }


    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Delivery Details");
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}