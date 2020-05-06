package com.example.jpwp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonSubmit;
    EditText textName, textSurname, textEmail, textPassword, textRepeatPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSubmit=(Button)findViewById(R.id.btn_submit);
        textName=(EditText) findViewById(R.id.txt_name);
        textSurname=(EditText) findViewById(R.id.txt_surname);
        textEmail=(EditText) findViewById(R.id.txt_email);
        textPassword=(EditText)findViewById(R.id.txt_password);
        textRepeatPassword=(EditText)findViewById(R.id.txt_password2);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=textName.getText().toString();
                String surname=textSurname.getText().toString();
                String email=textEmail.getText().toString();
                String password1 = Base64.encodeToString(textPassword.getText().toString().getBytes(), Base64.DEFAULT);
                String password2 = Base64.encodeToString(textRepeatPassword.getText().toString().getBytes(), Base64.DEFAULT);
                String type="registration";
                BackgroundTask backgroundTask= new BackgroundTask(getApplicationContext());
                backgroundTask.execute(type, name, surname, email, password1, password2);

            }
        });
    }
}
