package com.example.jhon.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jhon.loginapp.util.Constants;
import com.example.jhon.loginapp.util.DimensUtil;
import com.example.jhon.loginapp.util.ValidateStrings;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nombre,contrasena;
    Button btn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(getString(R.string.preferences_name),MODE_PRIVATE);
        nombre = (EditText) findViewById(R.id.nombre_usuario);
        contrasena = (EditText) findViewById(R.id.contrasena);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (ValidateStrings.validateUserName(nombre.getText().toString())
                && ValidateStrings.validateUserPass(contrasena.getText().toString())){
            editor = sharedPreferences.edit();
            editor.putBoolean(Constants.isLoged,true);
            editor.putString(Constants.userName,nombre.getText().toString());
            editor.commit();
            Intent intent = new Intent(this,DashBoardActivity.class);
            startActivity(intent);
        }
        else {

            //region Alerta de campos invalidos
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            TextView textView = new TextView(this);
            textView.setText(R.string.error);
            textView.setPadding(DimensUtil.pxToDp(18, this), DimensUtil.pxToDp(18, this),
                    DimensUtil.pxToDp(18, this), DimensUtil.pxToDp(18, this));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);
            textView.setTextColor(getResources().getColor(R.color.colorAlert));
            builder.setCustomTitle(textView);
            builder.setMessage(R.string.campos_invalidos);
            builder.setPositiveButton("Aceptar", null);
            builder.setCancelable(true);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            //endregion
        }

    }
}
