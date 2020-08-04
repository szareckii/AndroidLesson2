package com.geekbrains.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView textCity;
    private TextView textTempCurrent;
    private TextView textPlusOneHour;
    private TextView textPlusTwoHours;
    private TextView textPlusThreeHours;
    private TextView textTempNow;
    private TextView textTempPlusOneHour;
    private TextView textTempPlusTwoHours;
    private TextView textTempPlusThreeHours;
    private ImageView imageTypsWeather;
    private ImageView imageTypsWeatherNow;
    private ImageView imageTypsWeatherPlusOneHour;
    private ImageView imageTypsWeatherPlusTwoHours;
    private ImageView imageTypsWeatherPlusThreeHours;
    private ImageView imageTypeWeatherPlusOneDay;
    private ImageView imageTypeWeatherPlusOneDayNight;
    private ImageView imageTypeWeatherPlusTwoDay;
    private ImageView imageTypeWeatherPlusTwoDayNight;
    private ImageView imageTypeWeatherPlusThreeDay;
    private ImageView imageTypeWeatherPlusThreeDayNight;
    private TextView textCurrentDayPlusOne;
    private TextView textCurrentDayPlusTwo;
    private TextView textCurrentDayPlusThree;
    private TextView textTempCurrentDayPlusOne;
    private TextView textTempCurrentDayPlusOneNight;
    private TextView textTempCurrentDayPlusTwo;
    private TextView textTempCurrentDayPlusTwoNight;
    private TextView textTempCurrentDayPlusThree;
    private TextView textTempCurrentDayPlusThreeNight;
    private TextView textWindNow;
    private TextView textWindPlusOneHour;
    private TextView textWindPlusTwoHours;
    private TextView textWindPlusThreeHours;
    private TextView textPressureNow;
    private TextView textPressurePlusOneHour;
    private TextView textPressurePlusTwoHours;
    private TextView textPressurePlusThreeHours;
    private ImageView imgBtnSettings;
    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "MainAct." + instanceState + " - onCreate()");

        String cityName = getString(R.string.cityNameMoscow);
        textCity.setText(cityName);
        setTemp(cityName);
        findCurrentHour();
        setSettingsBtnClickBehavior();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"MainAct. onStart()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"MainAct. Повторный запуск!! - onRestoreInstanceState()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"MainAct. onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"MainAct. onPause()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"MainAct. onSaveInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"MainAct. onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"MainAct. onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"MainAct. onDestroy()");
    }


    /*Метод открытия окна с настройками*/
    private void setSettingsBtnClickBehavior() {
        imgBtnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    /*Метод задания погоды*/
    private void setTemp(String cityName) {
        switch (cityName) {
            case "Moscow":
            case "Москва":
                setWeatherForMoscow();
                break;
        }
    }

    /*Метод рандомного заполнения погоды в Москве*/
    private void setWeatherForMoscow() {
        String currentTemp;
        String tempPlusOneHour;
        String tempPlusTwoHours;
        String tempPlusThreeHours;
        String tempPlusOneDay;
        String tempPlusOneDayNight;
        String tempPlusTwoDays;
        String tempPlusTwoDaysNight;
        String tempPlusThreeDays;
        String tempPlusThreeDaysNight;
        String windNow;
        String windPlusOneHour;
        String windPlusTwoHours;
        String windPlusThreeHours;
        String pressureNow;
        String pressurePlusOneHour;
        String pressurePlusTwoHours;
        String pressurePlusThreeHours;
        currentTemp = "+28";
        textTempCurrent.setText(currentTemp);

        tempPlusOneHour = "+28";
        tempPlusTwoHours = "+22";
        tempPlusThreeHours = "+21";

        textTempNow.setText(currentTemp);

        textTempPlusOneHour.setText(tempPlusOneHour);
        textTempPlusTwoHours.setText(tempPlusTwoHours);
        textTempPlusThreeHours.setText(tempPlusThreeHours);
        textTempPlusThreeHours.setText(tempPlusThreeHours);

        imageTypsWeather.setImageResource(R.drawable.cloudysun);
        imageTypsWeatherNow.setImageResource(R.drawable.cloudysun);
        imageTypsWeatherPlusOneHour.setImageResource(R.drawable.cloudy);
        imageTypsWeatherPlusTwoHours.setImageResource(R.drawable.storm);
        imageTypsWeatherPlusThreeHours.setImageResource(R.drawable.storm);

        imageTypeWeatherPlusOneDay.setImageResource(R.drawable.cloudysun);
        imageTypeWeatherPlusOneDayNight.setImageResource(R.drawable.moon);
        imageTypeWeatherPlusTwoDay.setImageResource(R.drawable.sun);
        imageTypeWeatherPlusTwoDayNight.setImageResource(R.drawable.moon);
        imageTypeWeatherPlusThreeDay.setImageResource(R.drawable.cloudysunrainy);
        imageTypeWeatherPlusThreeDayNight.setImageResource(R.drawable.moonandcloudy);

        tempPlusOneDay = "+25";
        tempPlusOneDayNight = "+17";
        tempPlusTwoDays = "+26";
        tempPlusTwoDaysNight = "+20";
        tempPlusThreeDays = "+21";
        tempPlusThreeDaysNight = "+19";

        textTempCurrentDayPlusOne.setText(tempPlusOneDay);
        textTempCurrentDayPlusOneNight.setText(tempPlusOneDayNight);
        textTempCurrentDayPlusTwo.setText(tempPlusTwoDays);
        textTempCurrentDayPlusTwoNight.setText(tempPlusTwoDaysNight);
        textTempCurrentDayPlusThree.setText(tempPlusThreeDays);
        textTempCurrentDayPlusThreeNight.setText(tempPlusThreeDaysNight);

        windNow = "4.5";
        windPlusOneHour = "2.5";
        windPlusTwoHours = "15.4";
        windPlusThreeHours = "18.5";
        pressureNow = "765";
        pressurePlusOneHour = "750";
        pressurePlusTwoHours = "740";
        pressurePlusThreeHours = "745";

        textWindNow.setText(windNow);
        textWindPlusOneHour.setText(windPlusOneHour);
        textWindPlusTwoHours.setText(windPlusTwoHours);
        textWindPlusThreeHours.setText(windPlusThreeHours);
        textPressureNow.setText(pressureNow);
        textPressurePlusOneHour.setText(pressurePlusOneHour);
        textPressurePlusTwoHours.setText(pressurePlusTwoHours);
        textPressurePlusThreeHours.setText(pressurePlusThreeHours);
    }

    /*Метод определения текущего дня и часа и вывод на экран информации о ближайших днях и часах*/
    private void findCurrentHour() {
        Calendar cDayPlusOne = Calendar.getInstance();
        cDayPlusOne.add(Calendar.DAY_OF_MONTH, 1);
        Calendar cDayPlusTwo = Calendar.getInstance();
        cDayPlusTwo.add(Calendar.DAY_OF_MONTH, 2);
        Calendar cDayPlusThree = Calendar.getInstance();
        cDayPlusThree.add(Calendar.DAY_OF_MONTH, 3);

        @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat("dd/MM");

        textCurrentDayPlusOne.setText(df.format(cDayPlusOne.getTime()));
        textCurrentDayPlusTwo.setText(df.format(cDayPlusTwo.getTime()));
        textCurrentDayPlusThree.setText(df.format(cDayPlusThree.getTime()));

        Calendar cPlusOneHour = Calendar.getInstance();
        cPlusOneHour.set(Calendar.MINUTE, 0);
        cPlusOneHour.add(Calendar.HOUR, 3);

        Calendar cPlusTwoHours = Calendar.getInstance();
        cPlusTwoHours.set(Calendar.MINUTE, 0);
        cPlusTwoHours.add(Calendar.HOUR, 6) ;

        Calendar cPlusThreeHours = Calendar.getInstance();
        cPlusThreeHours.set(Calendar.MINUTE, 0);
        cPlusThreeHours.add(Calendar.HOUR, 9);

        @SuppressLint("SimpleDateFormat") DateFormat dfHour = new SimpleDateFormat("HH:mm");
        textPlusOneHour.setText(dfHour.format(cPlusOneHour.getTime()));
        textPlusTwoHours.setText(dfHour.format(cPlusTwoHours.getTime()));
        textPlusThreeHours.setText(dfHour.format(cPlusThreeHours.getTime()));
    }

    /*Метод инициализации полей из ресурсов*/
    private void initViews() {
        textCity = findViewById(R.id.textCity);
        textTempCurrent = findViewById(R.id.textTempCurrent);
        textPlusOneHour = findViewById(R.id.textPlusOneHour);
        textPlusTwoHours = findViewById(R.id.textPlusTwoHours);
        textPlusThreeHours = findViewById(R.id.textPlusThreeHours);
        textTempNow = findViewById(R.id.textTempNow);
        textTempPlusOneHour = findViewById(R.id.textTempPlusOneHour);
        textTempPlusTwoHours = findViewById(R.id.textTempPlusTwoHours);
        textTempPlusThreeHours = findViewById(R.id.textTempPlusThreeHours);
        imageTypsWeather = findViewById(R.id.imageTypsWeather);
        imageTypsWeatherNow = findViewById(R.id.imageTypsWeatherNow);
        imageTypsWeatherPlusOneHour = findViewById(R.id.imageTypsWeatherPlusOneHour);
        imageTypsWeatherPlusTwoHours = findViewById(R.id.imageTypsWeatherPlusTwoHours);
        imageTypsWeatherPlusThreeHours = findViewById(R.id.imageTypsWeatherPlusThreeHours);
        imageTypeWeatherPlusOneDay = findViewById(R.id.imageTypeWeatherPlusOneDay);
        imageTypeWeatherPlusOneDayNight = findViewById(R.id.imageTypeWeatherPlusOneDayNight);
        imageTypeWeatherPlusTwoDay = findViewById(R.id.imageTypeWeatherPlusTwoDay);
        imageTypeWeatherPlusTwoDayNight = findViewById(R.id.imageTypeWeatherPlusTwoDayNight);
        imageTypeWeatherPlusThreeDay = findViewById(R.id.imageTypeWeatherPlusThreeDay);
        imageTypeWeatherPlusThreeDayNight = findViewById(R.id.imageTypeWeatherPlusThreeDayNight);
        textCurrentDayPlusOne = findViewById(R.id.textCurrentDayPlusOne);
        textCurrentDayPlusTwo = findViewById(R.id.textCurrentDayPlusTwo);
        textCurrentDayPlusThree = findViewById(R.id.textCurrentDayPlusThree);
        textTempCurrentDayPlusOne = findViewById(R.id.textTempCurrentDayPlusOne);
        textTempCurrentDayPlusOneNight = findViewById(R.id.textTempCurrentDayPlusOneNight);
        textTempCurrentDayPlusTwo = findViewById(R.id.textTempCurrentDayPlusTwo);
        textTempCurrentDayPlusTwoNight = findViewById(R.id.textTempCurrentDayPlusTwoNight);
        textTempCurrentDayPlusThree = findViewById(R.id.textTempCurrentDayPlusThree);
        textTempCurrentDayPlusThreeNight = findViewById(R.id.textTempCurrentDayPlusThreeNight);
        textWindNow = findViewById(R.id.textWindNow);
        textWindPlusOneHour = findViewById(R.id.textWindPlusOneHour);
        textWindPlusTwoHours = findViewById(R.id.textWindPlusTwoHours);
        textWindPlusThreeHours = findViewById(R.id.textWindPlusThreeHours);
        textPressureNow = findViewById(R.id.textPressureNow);
        textPressurePlusOneHour = findViewById(R.id.textPressurePlusOneHour);
        textPressurePlusTwoHours = findViewById(R.id.textPressurePlusTwoHours);
        textPressurePlusThreeHours = findViewById(R.id.textPressurePlusThreeHours);
        imgBtnSettings = findViewById(R.id.imgBtnSettings);

    }
}