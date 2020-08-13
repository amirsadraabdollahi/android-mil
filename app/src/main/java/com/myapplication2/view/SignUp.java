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
    private Processor processor;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        this.processor = Processor.getProcessor();
    }

    public void signUp1(View view) {
        EditText usernameEditText = findViewById(R.id.usernameSignUp);
        String username = usernameEditText.getText().toString();
        EditText passwordEditText = findViewById(R.id.passwordSignUp);
        String password = passwordEditText.getText().toString();
        EditText emailEditText = findViewById(R.id.emailSignUp);
        String email = emailEditText.getText().toString();
        EditText phoneNumberEditText = findViewById(R.id.phoneNumberSignUp);
        String phoneNumber = phoneNumberEditText.getText().toString();
        //Todo : signUp and goto send email
        String result = processor.signUp(username, password, email, phoneNumber);
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        if(result.equals("you joined us ;)")){
            Intent intent = new Intent(this, EmailView.class);
            startActivity(intent);
        }
    }
}
