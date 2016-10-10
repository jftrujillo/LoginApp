package com.example.jhon.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jhon.loginapp.util.Constants;

public class RootActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    boolean isLoged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(
                getString(R.string.preferences_name),MODE_PRIVATE);
        isLoged = sharedPreferences.getBoolean(Constants.isLoged,false);
        if (isLoged){
            Intent intent = new Intent(this,DashBoardActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
