package com.example.fordlabs.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    //ApiClient apiClient;
    ApiInterface apiInterface;
    TextView base;
    TextView timezone;
    TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        //get the fields to populate data
        base = findViewById(R.id.base);
        timezone = findViewById(R.id.timezone);
        name = findViewById(R.id.name);


        Bundle receivedBundle = getIntent().getExtras();
        String cityName = receivedBundle.get("cityName").toString();

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        final Call<WeatherResponse> weatherResponseCall = apiInterface.getWeatherResponse(cityName);

        weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

                Log.d("msg************",response.body().toString());
                WeatherResponse weatherResponseObj = response.body();
                base.setText(weatherResponseObj.getName());
                timezone.setText(String.valueOf(weatherResponseObj.getTimezone()));
                name.setText(weatherResponseObj.getName());

            }
            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("msg","error");
            }
        });

    }

}
