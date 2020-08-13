package com.myapplication2.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.myapplication2.R;
import com.myapplication2.controller.Processor;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    private Intent intent;
    private Processor processor;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        this.processor = Processor.getProcessor();
        intent = this.getIntent();
    }

    public void signUp1(View view) {
        EditText usernameEditText = findViewById(R.id.usernameSignUp);
        String username = String.valueOf(usernameEditText.getText());
        EditText passwordEditText = findViewById(R.id.passwordSignUp);
        String password = String.valueOf(passwordEditText.getText());
        EditText emailEditText = findViewById(R.id.emailSignUp);
        String email = String.valueOf(emailEditText.getText());
        EditText phoneNumberEditText = findViewById(R.id.phoneNumberSignUp);
        String phoneNumber = String.valueOf(phoneNumberEditText.getText());
        //Todo : signUp and goto send email
        Toast.makeText(this, processor.signUp(username, password, email, phoneNumber), Toast.LENGTH_LONG).show();
    }
}
