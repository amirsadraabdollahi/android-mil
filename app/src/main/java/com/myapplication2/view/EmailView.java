package com.myapplication2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
        EditText emailAddress = findViewById(R.id.receiverEmail);
        EditText emailSubject = findViewById(R.id.subject);
        EditText emailContext = findViewById(R.id.context);
        EditText emailUrl = findViewById(R.id.url);
        String emailUrlString = emailUrl.getText().toString();
        String emailAddressText = emailAddress.getText().toString();
        if (emailAddressText.isEmpty()) {
            Toast.makeText(this, "please fill receiver email", Toast.LENGTH_LONG).show();
            return;
        }
        String emailSubjectText = emailSubject.getText().toString();
        if (emailSubjectText.isEmpty()) {
            Toast.makeText(this, "please fill email subject", Toast.LENGTH_LONG).show();
            return;
        }
        String emailContextText = emailContext.getText().toString();
        Toast.makeText(this, processor.sendEmail(emailAddressText, emailSubjectText, emailContextText, emailUrlString), Toast.LENGTH_LONG).show();
        emailAddress.getText().clear();
        emailSubject.getText().clear();
        emailContext.getText().clear();
    }

    public void sendRealEmail(View view){
        Intent intent = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_EMAIL);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "amirsadrathirteen13@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "first subject");
        intent.putExtra(Intent.EXTRA_TEXT, "text first text first");
        intent.setType("message/rfc822");
        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }


    public void inbox(View view) {
        Intent intent = new Intent(this, EmailInboxActivity.class);
        startActivity(intent);
    }
}