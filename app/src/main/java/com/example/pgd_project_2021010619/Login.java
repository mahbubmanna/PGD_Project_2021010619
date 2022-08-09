package com.example.pgd_project_2021010619;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText userName;
    EditText password;
    Button loginButton;
    Button createAccountButton;
    CheckBox showHideBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        createAccountButton = findViewById(R.id.createAccountButton);
        showHideBox = findViewById(R.id.showHideBox);
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

        showHideBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }

            }
        });
    }
}