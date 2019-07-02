package com.example.fordlabs.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getWeather(View view){
        EditText cityName = findViewById(R.id.cityName);
        Intent secondIntent = new Intent(this,SecondActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("cityName",cityName.getText().toString());
        secondIntent.putExtras(bundle);
        startActivity(secondIntent);
    }
}