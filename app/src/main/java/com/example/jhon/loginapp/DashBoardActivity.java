package com.example.jhon.loginapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jhon.loginapp.util.Constants;

public class DashBoardActivity extends AppCompatActivity {
    TextView hola;
    SharedPreferences sharedPreferences;
    String nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        hola = (TextView) findViewById(R.id.hola);
        sharedPreferences = getSharedPreferences(
                getString(R.string.preferences_name),
                MODE_PRIVATE);

        nombreUsuario = sharedPreferences.getString(
                Constants.userName,"NO USER NAME");

        hola.setText("Hola: " + nombreUsuario);

    }
}
