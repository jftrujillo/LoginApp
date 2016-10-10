package com.example.jhon.loginapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jhon.loginapp.util.Constants;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {
    TextView hola;
    SharedPreferences sharedPreferences;
    String nombreUsuario;
    SwitchCompat dulces,asados,comidaRapida;
    Button btn,btnConfiguracion;

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
        btnConfiguracion = (Button) findViewById(R.id.btn_configuracion);
        btnConfiguracion.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn:
                Toast.makeText(this, "Cambio en click en boton", Toast.LENGTH_SHORT).show();
                FileOutputStream fileOutputStream;
                try {
                    fileOutputStream = openFileOutput(Constants.nombreArchivo, MODE_PRIVATE);
                    String mensage = "";
                    if (dulces.isChecked()){
                        mensage = mensage + Constants.dulces + "&";
                    }
                    if (asados.isChecked()){
                        mensage = "&" + mensage + Constants.asados + "&";
                    }
                    if (comidaRapida.isChecked()){
                        mensage = "&" + mensage + Constants.comidaRapida;
                    }
                    fileOutputStream.write(mensage.getBytes());
                    fileOutputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_configuracion:
                startActivity(new Intent(this,ConfiguracionAcitivity.class));
                break;
        }
    }
}
