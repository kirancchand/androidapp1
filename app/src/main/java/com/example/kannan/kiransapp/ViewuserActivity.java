package com.example.kannan.kiransapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewuserActivity extends AppCompatActivity {

    TextView id ,pwd;
    DataBaseHelper db;
    UserModel ob1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewuser);
        id=(TextView)findViewById(R.id.textView);
      pwd=(TextView)findViewById(R.id.textView2);

        DataBaseHelper db=new DataBaseHelper(getApplicationContext());
        
        db.getAllData();
        id.setText(ob1.getEmailid());
      pwd.setText(ob1.getPassword());



    }
}
