package com.example.kannan.kiransapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyprofileActivity extends AppCompatActivity {

    Button add;
    EditText friend_name;
    DataBaseHelper myDb;
    FriendlistModel friendlistmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);

        friendlistmodel=new FriendlistModel();
        myDb=new DataBaseHelper(getApplicationContext());
        add=(Button)findViewById(R.id.add);
        friend_name=(EditText)findViewById(R.id.friendname) ;
        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addFriend();


                    }

                }
        );


    }

    public void addFriend()
    {

        final String Friend_name;
        final int r_value;
        friend_name = (EditText) findViewById(R.id.friendname);

        Friend_name=friend_name.getText().toString();

        friendlistmodel.setFriendname(Friend_name);

        r_value=myDb.isaddFriend(friendlistmodel);
        if(r_value==1)
        {
            Toast.makeText(this,"Added into database",
                    Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Cant Added into database",
                    Toast.LENGTH_SHORT).show();
        }

    }
}
