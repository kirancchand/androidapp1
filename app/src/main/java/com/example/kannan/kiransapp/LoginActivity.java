package com.example.kannan.kiransapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button loginbtn;
    EditText emailid,password;
    DataBaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myDb = new DataBaseHelper(getApplicationContext());
        myDb=new DataBaseHelper(this);
        loginbtn=(Button)findViewById(R.id.loginbutton);
        loginbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        login();
                    }

                }
        );
    }

    public void login()
    {
        final String email,pwd;
        emailid = (EditText) findViewById(R.id.emailid);
        password = (EditText) findViewById(R.id.password);


        email=emailid.getText().toString();
        pwd=password.getText().toString();

        boolean checkUser = myDb.checkUser(email,pwd);

        if(checkUser)
        {
            Toast.makeText(this,"user exist",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent (this, HomeActivity.class);
            startActivity(intent);
        }
        else
            {
                Toast.makeText(this,"user not exist",
                        Toast.LENGTH_SHORT).show();
               Intent intent = new Intent (this, LoginActivity.class);
                startActivity(intent);

        }

    }
}
