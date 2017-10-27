package com.flora.flora_labexer3;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUserName,etPassWord;
    Button btnSaveSharedPreferences, btnSaveInternalStorage, btnNext;
    SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = (EditText)findViewById(R.id.username_field);
        etPassWord = (EditText)findViewById(R.id.password_field);
        btnSaveSharedPreferences = (Button)findViewById(R.id.saveSharedPreferences_button);
        btnSaveInternalStorage = (Button)findViewById(R.id.saveInternalStorage_button);
        btnNext = (Button)findViewById(R.id.next_button);


        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void saveSharedPreferences(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",etUserName.getText().toString());
        editor.putString("pwd", etPassWord.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved in Shared Preferences!", Toast.LENGTH_LONG).show();
    }
}
