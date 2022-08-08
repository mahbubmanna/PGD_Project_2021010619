package com.example.pgd_project_2021010619;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText userName;
    EditText password;
    Button loginButton;
    Button createAccountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        createAccountButton = findViewById(R.id.createAccountButton);
    }

    @Override
    protected void onStart() {
        super.onStart();

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrationIntent = new Intent( Login.this, Registration.class);
                startActivity(registrationIntent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName_S = userName.getText().toString();
                String password_S = password.getText().toString();
                boolean isAccountAvailable = false;

                for (int i = 0; i< Registration.data.size(); i++){
                    if (Registration.data.get(i).getUserName().equals(userName_S) && Registration.data.get(i).getPassword().equals(password_S)){
                        isAccountAvailable = true;
                    }
                    if(isAccountAvailable)
                        break;
                }

                if(isAccountAvailable){
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Home.class);
                    intent.putExtra("user", userName_S);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Login.this, "Account Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}