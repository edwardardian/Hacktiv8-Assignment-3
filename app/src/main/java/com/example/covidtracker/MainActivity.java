package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView totalCasesTitle;

    TextView totalCases;

    TextView totalDeathsTitle;

    TextView totalDeaths;

    TextView totalRecoveredTitle;

    TextView totalRecovered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalCasesTitle = findViewById(R.id.totalCasesTitle);
        totalCases = findViewById(R.id.totalCases);
        totalDeathsTitle = findViewById(R.id.totalDeathsTitle);
        totalDeaths = findViewById(R.id.totalDeaths);
        totalRecoveredTitle = findViewById(R.id.totalRecoveredTitle);
        totalRecovered = findViewById(R.id.totalRecovered);

        getTotalCovidData();
    }

    private void getTotalCovidData() {
        Call<CovidData> callCovidData = RetrofitClient.getInstance().apiService().getCovidData();
        callCovidData.enqueue(new Callback<CovidData>() {
            @Override
            public void onResponse(Call<CovidData> call, Response<CovidData> response) {
                CovidData covidData = response.body();
                printTotalCovidData(covidData);
                }

            @Override
            public void onFailure(Call<CovidData> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void printTotalCovidData(CovidData covidData){
        totalCases.setText(String.valueOf(covidData.getCasesData()));
        totalDeaths.setText(String.valueOf(covidData.getDeathsData()));
        totalRecovered.setText(String.valueOf(covidData.getRecoveredData()));
    }
}