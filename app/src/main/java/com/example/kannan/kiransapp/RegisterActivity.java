package com.example.kannan.kiransapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DataBaseHelper myDb;
    Button registerbtn;
    EditText emailid,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myDb = new DataBaseHelper(getApplicationContext());
        myDb=new DataBaseHelper(this);

        registerbtn=(Button)findViewById(R.id.registerbutton);
        registerbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        registration();
                    }

                }
        );

    }

    public  void registration()
    {
        final String email,pwd;
        emailid = (EditText) findViewById(R.id.emailid);
        password = (EditText) findViewById(R.id.password);

        email=emailid.getText().toString();
        pwd=password.getText().toString();
        boolean isInserted = myDb.insertData(email,pwd);
        if(isInserted)
        {
            Toast.makeText(this,"true",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent (this, MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"false",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent (this, MainActivity.class);
            startActivity(intent);

        }
        /*Toast.makeText(this,emailid.getText().toString(),
                Toast.LENGTH_SHORT).show();*/

    }
}
