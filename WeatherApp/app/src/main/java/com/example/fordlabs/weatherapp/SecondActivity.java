package com.example.fordlabs.weatherapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.fordlabs.weatherapp.databinding.ViewpagerItemBinding2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    //ApiClient apiClient;
    ArrayList<WeatherResponse> weatherResponseObjList = new ArrayList<WeatherResponse>();

    String[] rank;

    ApiInterface apiInterface;
    TextView base;
    TextView timezone;
    TextView name;

    ViewPager viewPager ;
    MyPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main);

        rank = new String[]{"1", "2"}; //no of view pager instances needed.

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        String [] cityNames ={"London,uk","Chennai"};

        for(String city : cityNames){

            final Call<WeatherResponse> weatherResponseCall = apiInterface.getWeatherResponse(city);

            weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
                @Override
                public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                    Log.d("msg************", response.body().toString());
                    if (response.isSuccessful()) {
                        setResouceForViewPager(response);

                    }

                }

                @Override
                public void onFailure(Call<WeatherResponse> call, Throwable t) {
                    Log.d("msg", "error");
                }
            });

        }
    }


       public  void setResouceForViewPager(Response<WeatherResponse> response) {
           if(null != response){
               weatherResponseObjList.add(response.body());
           }

           if(weatherResponseObjList.size() == 2){
               viewPager = (ViewPager)findViewById(R.id.pager);
               // Pass results to ViewPagerAdapter Class
               adapter = new MyPagerAdapter(SecondActivity.this, rank, weatherResponseObjList);
               // Binds the Adapter to the ViewPager
               viewPager.setAdapter(adapter);
           }

        }

    }


