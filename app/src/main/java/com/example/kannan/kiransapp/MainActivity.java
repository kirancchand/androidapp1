package com.example.kannan.kiransapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Button login_button,register_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_button = (Button)findViewById(R.id.loginbtn);
        register_button = (Button)findViewById(R.id.registerbtn);
        login_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         login_click();
                        }

                    }
        );

        register_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        register_click();
                    }

                }
        );


    }

    public  void login_click()
    {
        Toast.makeText(this,"pressed login",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (this, LoginActivity.class);
        startActivity(intent);
    }

    public  void register_click()
    {
        Intent intent = new Intent (this, RegisterActivity.class);
        startActivity(intent);
    }
}
