package com.example.kannan.kiransapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Button my_profile,view_user,do_job;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        my_profile=(Button)findViewById(R.id.myprofile);
        my_profile.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        MyProfile();

                    }

                }
        );
       view_user=(Button)findViewById(R.id.viewuser);
        view_user.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i=new Intent(HomeActivity.this,ViewuserActivity .class);
                        startActivity(i);

                    }

                }
        );

    }

    public void MyProfile()
    {
        Intent intent = new Intent (this,MyprofileActivity.class);
        startActivity(intent);
        Toast.makeText(HomeActivity.this,"user exist",
                Toast.LENGTH_SHORT).show();
    }
}
