package com.example.harkkatyo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private TextView txtWeather;
    private TextView txtPopulation;
    private EditText editTextTown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        txtPopulation = findViewById(R.id.txtPopulation);
        txtWeather = findViewById(R.id.txtWeather);
        editTextTown = findViewById(R.id.editTextTown);
        Button btnTab = findViewById(R.id.btnTab);




    }


    public void onTabClick(View view)   {
        Intent intent = new Intent(this, TabActivity.class);
        startActivity(intent);
    }


    public void onBtnTownClick(View view)   {
        Context context = this;
        MunicipalityDataRetriever mr = new MunicipalityDataRetriever();
        WeatherDataRetriever wr = new WeatherDataRetriever();
        String location = editTextTown.getText().toString();

        ExecutorService service = Executors.newSingleThreadExecutor();


        service.execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<MunicipalityData> populationData = mr.getData(context, location);
                WeatherData weatherData = wr.getWeatherData(location);
                if (populationData == null) {
                    return;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String s = "";
                        for (MunicipalityData data : populationData)    {
                            s = s + data.getYear() + ": " + data.getPopulation() + "\n";
                        }

                        txtPopulation.setText(s);

                        txtWeather.setText(
                                weatherData.getName() + "\n" +
                                "sää nyt :" +weatherData.getMain() + " (" + weatherData.getDescription()
                                + ") \n" + "lämpötila: " + weatherData.getTemperature() + "K\n" +
                                        "Tuulennopeus: " + weatherData.getWindSpeed() + "m/s\n"
                        );

                    }
                });

            }
        });




    }
}