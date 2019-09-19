package com.example.hngtask1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText theName = (EditText) findViewById(R.id.logname);
        final EditText thePassword = (EditText) findViewById(R.id.logpassword);
        Button btnLogin = (Button) findViewById(R.id.buttonlogin);
        Button btnRegister = (Button) findViewById(R.id.buttonregister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = theName.getText().toString();
                String thepassword = thePassword.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                String details = preferences.getString(user + thepassword + "data", "Username or Password is Incorrect.");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display",details);
                editor.commit();

                Intent displayintent = new Intent(MainActivity.this, DisplayScreen.class);
                startActivity(displayintent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registration = new Intent(MainActivity.this, Registration.class);
                startActivity(registration);
            }
        });
    }
}
