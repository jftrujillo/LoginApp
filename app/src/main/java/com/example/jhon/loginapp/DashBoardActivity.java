package com.example.jhon.loginapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jhon.loginapp.util.Constants;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {
    TextView hola;
    SharedPreferences sharedPreferences;
    String nombreUsuario;
    SwitchCompat dulces,asados,comidaRapida;
    Button btn;

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
        dulces = (SwitchCompat) findViewById(R.id.dulces);
        dulces.setOnClickListener(this);
        asados = (SwitchCompat) findViewById(R.id.asados);
        asados.setOnClickListener(this);
        comidaRapida = (SwitchCompat) findViewById(R.id.comida_rapida);
        comidaRapida.setOnClickListener(this);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dulces:

                break;
            case R.id.asados:

                break;
            case R.id.comida_rapida:

                break;
            case R.id.btn:

                break;
        }
    }
}
