package com.example.hngtask1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final EditText userName = (EditText) findViewById(R.id.Regname);
        final EditText password = (EditText) findViewById(R.id.Regpassowrd);
        final EditText email = (EditText) findViewById(R.id.Regemail);
        Button btnRegister = (Button) findViewById(R.id.RegButton);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newPassword = password.getText().toString();
                String newEmail = email.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(newUser + newPassword + "data", newUser + "----" + newEmail);
                editor.commit();

                Intent loginintent = new Intent(Registration.this, MainActivity.class);
                startActivity(loginintent);


            }
        });

    }
}
