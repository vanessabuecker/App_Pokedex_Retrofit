package com.vbuecker.pokedexretrofitapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class User_Interface extends AppCompatActivity {

    private EditText name_editText;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__interface);

        name_editText = findViewById(R.id.name_edit_text);
        Button botao = findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_editText.getText().toString().trim();
                SharedPreferences sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name);
                editor.apply();

                startActivity(new Intent(User_Interface.this, StartActivity.class));

                finish();
            }
        });
    }
}
