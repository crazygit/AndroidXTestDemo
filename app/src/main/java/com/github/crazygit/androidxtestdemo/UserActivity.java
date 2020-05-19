package com.github.crazygit.androidxtestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    private TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        tvMsg = findViewById(R.id.tv_msg);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        if (username.equals("admin") && password.equals("secret")) {
            tvMsg.setText("welcome");
        } else {
            tvMsg.setText("wrong");
        }
    }
}
