package com.myapplication2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.myapplication2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        EditText usernameEditText = findViewById(R.id.username);
        String username = String.valueOf(usernameEditText.getText());
        EditText passwordEditText = findViewById(R.id.password);
        String password = String.valueOf(passwordEditText.getText());
        //Todo : go to send email


    }

    public void signUp(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}