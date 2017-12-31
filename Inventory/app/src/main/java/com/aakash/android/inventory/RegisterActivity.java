package com.aakash.android.inventory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText usernameText = (EditText) findViewById(R.id.nameText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final EditText emailText = (EditText) findViewById(R.id.emailText);
        Button registerButton = (Button) findViewById(R.id.email_register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("MyPref",MODE_PRIVATE);
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                String email = emailText.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", username);
                editor.putString("password",password);
                editor.putString("email", email);

                editor.commit();

                Intent loginScreen = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginScreen);
            }
        });
    }
}
