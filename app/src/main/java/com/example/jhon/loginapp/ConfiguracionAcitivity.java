package com.example.jhon.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jhon.loginapp.util.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfiguracionAcitivity extends AppCompatActivity {
    TextView contenido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_acitivity);
        contenido = (TextView) findViewById(R.id.contenido);
        try {
            FileInputStream fileInputStream = openFileInput(Constants.nombreArchivo);
            int content;
            StringBuilder mensaje = new  StringBuilder();

            while ((content = fileInputStream.read()) != -1){
                mensaje.append((char) content);
            }
            fileInputStream.close();
            contenido.setText(mensaje);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
