package com.random.loginscreen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.random.loginscreen.databinding.ActivityLoginActivtiyBinding;

public class loginActivtiy extends AppCompatActivity {

    ActivityLoginActivtiyBinding binding;
    DatabaseHelper databaseHelper;
    TextView newUser;
    EditText editTextEmail, editTextPassword;
    ImageView nextImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginActivtiyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper=new DatabaseHelper(this);

        binding.nextImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.editTextEmail.getText().toString();
                String password=binding.editTextPassword.getText().toString();

                if(email.equals("") || password.equals("")){
                    Toast.makeText(loginActivtiy.this,"Lütfen Gerekli Yerleri Doldurun",Toast.LENGTH_SHORT).show();
                }else {
                    Boolean cheackCredintials=databaseHelper.checkEmailPassword(email,password);

                    if(cheackCredintials==true){
                        Toast.makeText(loginActivtiy.this,"Giriş Başarılı",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),AnaSayfa.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(loginActivtiy.this,"Geçersiz kimlik bilgileri",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginActivtiy.this,signUpActivtiy.class);
                startActivity(intent);
            }
        });

        newUser = findViewById(R.id.newUser);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        nextImage=findViewById(R.id.nextImage);


        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newUser = new Intent(loginActivtiy.this, signUpActivtiy.class);
                startActivity(newUser);
                finish();
            }
        });

    }
}
