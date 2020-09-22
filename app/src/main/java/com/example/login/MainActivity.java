package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txt1;
    private EditText txt2;
    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (EditText) findViewById(R.id.texto1);
        txt2 = (EditText) findViewById(R.id.texto2);
        btn1 = (Button) findViewById(R.id.button);
        Preferencias1();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferencias2();
            }
        });
    }
    public void Preferencias1(){
        SharedPreferences preferences = getSharedPreferences("UserPreferens", Context.MODE_PRIVATE);
        txt1.setText(preferences.getString("nombres1",""));
        txt2.setText(preferences.getString("nombres2",""));
    }
    public void Preferencias2(){
        SharedPreferences preferences = getSharedPreferences("UserPreferens", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String nombres1 = txt1.getText().toString();
        String nombres2 = txt2.getText().toString();
        editor.putString("nombres1", nombres1);
        editor.putString("nombres2", nombres2);
        editor.commit();

    }


}
