package com.myapplication2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.myapplication2.R;
import com.myapplication2.controller.Processor;

public class MainActivity extends AppCompatActivity {

    private Processor processor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.processor = Processor.getProcessor();
    }

    public void login(View view) {
        EditText usernameEditText = findViewById(R.id.username);
        String username = usernameEditText.getText().toString();
        EditText passwordEditText = findViewById(R.id.password);
        String password = passwordEditText.getText().toString();
        String result = processor.login(username, password);
        if (result.equals("successfully logged in")) {
            Intent intent = new Intent(this, EmailView.class);
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            startActivity(intent);
            return;
        }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    public void signUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}