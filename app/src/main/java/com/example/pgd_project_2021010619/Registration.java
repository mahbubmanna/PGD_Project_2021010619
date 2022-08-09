package com.example.pgd_project_2021010619;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class Registration extends AppCompatActivity {

    public static ArrayList<Person> data = new ArrayList<>();

    EditText userName;
    EditText password;
    Button regButton;
    CheckBox showHideBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        regButton = findViewById(R.id.regButton);
        showHideBox = findViewById(R.id.showHideBox);
    }

    @Override
    protected void onStart() {
        super.onStart();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName_S = userName.getText().toString();
                String password_S = password.getText().toString();

                data.add( new Person(userName_S, password_S));
                Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                Intent loginIntent = new Intent(Registration.this, Login.class);
                startActivity(loginIntent);
            }
        });

        showHideBox.setOnCheckedChangeListener(new OnCheckedChangeListener(){
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