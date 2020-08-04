package com.geekbrains.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    private ImageButton imgBtnGoBack;
    private String nameCity;
    private TextView editNameChooseCity;
    private TextView textValueCountHoursBetweenForecasts;
    private SeekBar seekBarCountHoursBetweenForecasts;
    private final String TAG = "myLogs";
    private int countHoursBetweenForecasts = 3;
    private TextView textBtnMoscow;
    private TextView textBtnLondon;
    private TextView textBtnNewYork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        findView();
        textValueCountHoursBetweenForecasts.setText("3");

        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "SettingsAct." + instanceState + " - onCreate()");

        seekBarCountHoursBetweenForecasts.setOnSeekBarChangeListener(this);
        setBackBtnClickBehavior();
        setChooseCityBtnEnterClickBehavior();
        textBtnMoscow.setOnClickListener(new cityNameBtnClickListener());
        textBtnLondon.setOnClickListener(new cityNameBtnClickListener());
        textBtnNewYork.setOnClickListener(new cityNameBtnClickListener());
    }

    public class cityNameBtnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            TextView tv = (TextView)view;
            switch (tv.getId()) {
                case R.id.textCityMoscow: editNameChooseCity.setText(textBtnMoscow.getText().toString());
                    break;
                case R.id.textCityLondon: editNameChooseCity.setText(textBtnLondon.getText().toString());
                    break;
                case R.id.textCityNewYork: editNameChooseCity.setText(textBtnNewYork.getText().toString());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    /*Т.к. у SeekBar минимальное значение 0 (до 26 API- ненастраиваемое), то делаем поправку на 1,
    чтобы минимальное значение получилось равное 1*/
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        textValueCountHoursBetweenForecasts.setText(String.valueOf(seekBar.getProgress() + 1));
        countHoursBetweenForecasts = seekBar.getProgress() + 1;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "SettingsAct. onStart()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "SettingsAct. Повторный запуск!! - onRestoreInstanceState()");
        countHoursBetweenForecasts = saveInstanceState.getInt("CountHoursBetweenForecasts");              // Восстанавливаем количество часов между прогнозами
        textValueCountHoursBetweenForecasts.setText(String.valueOf(countHoursBetweenForecasts));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "SettingsAct. onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "SettingsAct. onPause()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "SettingsAct. onSaveInstanceState()");
        saveInstanceState.putInt("CountHoursBetweenForecasts", countHoursBetweenForecasts); // Сохраняем количество часов между прогнозами
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "SettingsAct. onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "SettingsAct. onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "SettingsAct. onDestroy()");
    }

    /*Метод возврата на Activity_Main*/
    private void setBackBtnClickBehavior() {
        imgBtnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameCity == null && !editNameChooseCity.getText().toString().equals("")) {
                    nameCity = editNameChooseCity.getText().toString();
                }
                if (nameCity != null) {
                    Intent intentResult = new Intent();
                    intentResult.putExtra("NameCity", nameCity);
                    setResult(RESULT_OK, intentResult);
                    Log.d(TAG, "SettingsAct. NameCity: " + nameCity);
                }
                finish();
            }
        });
    }

    /*Метод выбора города по нажатию по Enter*/
    private void setChooseCityBtnEnterClickBehavior() {
        editNameChooseCity.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
                        (i == KeyEvent.KEYCODE_ENTER)) {
                    nameCity = editNameChooseCity.getText().toString();
                    return true;
                }
                return false;
            }
        });
    }

    /*Метод инициализации полей из ресурсов*/
    private void findView() {
        imgBtnGoBack = findViewById(R.id.imgBtnGoBack);
        editNameChooseCity = findViewById(R.id.editNameChooseCity);
        textValueCountHoursBetweenForecasts = findViewById(R.id.textValueCountHoursBetweenForecasts);
        seekBarCountHoursBetweenForecasts = findViewById(R.id.seekBarCountHoursBetweenForecasts);
        textBtnMoscow = findViewById(R.id.textCityMoscow);
        textBtnLondon = findViewById(R.id.textCityLondon);
        textBtnNewYork = findViewById(R.id.textCityNewYork);
    }
}
