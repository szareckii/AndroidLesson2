package com.geekbrains.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {
    private ImageButton imgBtnGoBack;
    private String nameCity;
    private TextView editNameChooseCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        findView();
        setBackBtnClickBehavior();
        setConfirmChooseCityBtnClickBehavior();
        setChooseCityBtnEnterClickBehavior();
    }

    /*Метод возврата на Activity_Main*/
    private void setBackBtnClickBehavior() {
        imgBtnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /*Метод подвтерждения выбора города*/
    private void setConfirmChooseCityBtnClickBehavior() {
        imgBtnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                    String nameCity = editNameChooseCity.getText().toString();
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

    }
}
