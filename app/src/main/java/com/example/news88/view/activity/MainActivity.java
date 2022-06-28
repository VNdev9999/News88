package com.example.news88.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.news88.R;
import com.example.news88.viewmodel.SharedViewModel;

public class MainActivity extends AppCompatActivity {

    private SharedViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}