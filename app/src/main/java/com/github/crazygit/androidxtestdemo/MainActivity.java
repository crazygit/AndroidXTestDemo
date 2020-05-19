package com.github.crazygit.androidxtestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;

    @VisibleForTesting
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameInput = findViewById(R.id.input_username);
        passwordInput = findViewById(R.id.input_password);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                intent.putExtra("username", usernameInput.getText().toString().trim());
                intent.putExtra("password", passwordInput.getText().toString().trim());
                startActivity(intent);
            }
        });
    }
}
