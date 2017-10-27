package com.flora.flora_labexer3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etUserName,etPassWord;
    Button btnSaveSharedPreferences, btnSaveInternalStorage, btnNext;
    FileOutputStream fos;
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


        preferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
    }

    public void savePreferences(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",etUserName.getText().toString());
        editor.putString("pass", etPassWord.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved in Shared Preferences!", Toast.LENGTH_LONG).show();
    }

    public void saveStorage (View view) {
        String message = "username is " + etUserName.getText().toString() + " and password is " + etPassWord.getText().toString()+ " in Internal Storage";

        try{
            fos = openFileOutput("output.txt", Context.MODE_PRIVATE);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Saved in Internal Storage!", Toast.LENGTH_LONG).show();

    }

    public void nextPage(View view){
        Intent intent = new Intent(this, DisplayActivity.class);
        startActivity(intent);
    }

}

