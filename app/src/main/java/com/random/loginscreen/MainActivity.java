package com.random.loginscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       login=findViewById(R.id.login);
       signup=findViewById(R.id.signup);

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent login=new Intent(MainActivity.this,loginActivtiy.class);
               startActivity(login);
           }
       });
       signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent signup=new Intent( MainActivity.this,signUpActivtiy.class);
               startActivity(signup);
           }
       });

    }
}