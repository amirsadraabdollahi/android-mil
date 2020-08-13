package com.myapplication2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.myapplication2.R;
import com.myapplication2.controller.Processor;

public class EmailView extends AppCompatActivity {
    private Processor processor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        this.processor = Processor.getProcessor();
    }

    public void sendEmail(View view) {
        EditText emailAddress = view.findViewById(R.id.receiverEmail);
        EditText emailSubject = view.findViewById(R.id.subject);
        EditText emailContext = view.findViewById(R.id.context);
        String emailAddressText = String.valueOf(emailAddress.getText());
        if (emailAddressText.isEmpty()) {
            Toast.makeText(this, "please fill receiver email", Toast.LENGTH_LONG).show();
            return;
        }
        String emailSubjectText = String.valueOf(emailSubject.getText());
        if (emailSubjectText.isEmpty()) {
            Toast.makeText(this, "please fill email subject", Toast.LENGTH_LONG).show();
            return;
        }
        String emailContextText = String.valueOf(emailContext.getText());
        Toast.makeText(this, processor.sendEmail(emailAddressText, emailSubjectText, emailContextText), Toast.LENGTH_LONG).show();
        emailAddress.getText().clear();
        emailSubject.getText().clear();
        emailContext.getText().clear();

    }
}