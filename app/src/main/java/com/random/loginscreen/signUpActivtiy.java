package com.random.loginscreen;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
import com.random.loginscreen.databinding.ActivitySignUpActivtiyBinding;

public class signUpActivtiy extends AppCompatActivity {
   ActivitySignUpActivtiyBinding binding;
    DatabaseHelper databaseHelper;
    TextView haveanAccount;
    ImageView kayitButton;
    View view;
    EditText editTextName,editTextEmail,editTextPassword,editTextRePassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_activtiy);

        binding=ActivitySignUpActivtiyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper=new DatabaseHelper(this);

        haveanAccount=findViewById(R.id.haveanAccount);
        kayitButton=findViewById(R.id.kayitButton);
        editTextName=findViewById(R.id.editTextName);
        editTextEmail=findViewById(R.id.editTextEmaillogin);
        editTextPassword=findViewById(R.id.editTextPasswordlogin);
        editTextRePassword=findViewById(R.id.editTextRePasswordlogin);
        view = findViewById(android.R.id.content);

        binding.kayitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.editTextEmaillogin.getText().toString();
                String password=binding.editTextPasswordlogin.getText().toString();
                String confirmpassword=binding.editTextRePasswordlogin.getText().toString();

                if(email.equals("") || password.equals("") || confirmpassword.equals(""))
                {
                    Toast.makeText(signUpActivtiy.this,"Lütfen Eksiksiz Bir Şekilde doldurun",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(password.equals(confirmpassword))
                    {
                        Boolean checkUsersEmail=databaseHelper.checkEmail(email);

                        if(checkUsersEmail==false)
                        {
                            Boolean insert=databaseHelper.insertData(email,password);
                            if(insert==true)
                            {
                                Toast.makeText(signUpActivtiy.this,"Kayit Başarili",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),loginActivtiy.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(signUpActivtiy.this,"Giriş Başarısız",Toast.LENGTH_SHORT);
                            }
                        }else
                        {
                            Toast.makeText(signUpActivtiy.this,"Böyle Bir Hesap var, Lütfen Giriş Yapın",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(signUpActivtiy.this,"Geçersiz Şifre",Toast.LENGTH_SHORT);
                    }
                }
            }
        });

        binding.haveanAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),loginActivtiy.class);
                startActivity(intent);
            }
        });
    }
}