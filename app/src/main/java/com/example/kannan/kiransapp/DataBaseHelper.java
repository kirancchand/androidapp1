package com.example.kannan.kiransapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Andro.db";
    public static final String TABLE_NAME = "Usertbl";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "EMAILID";
    public static final String COL_3 = "PASSWORD";

    public static final String FRIEND_TABLE = "Friendtbl";
    public static final String COL_4 = "FRIENDNAME";

    SQLiteDatabase db;
    public DataBaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
        db=this.getWritableDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,EMAILID TEXT NOT NULL,PASSWORD TEXT NOT NULL)");
        Log.e("database", "database table"+TABLE_NAME+"created");

        db.execSQL(" CREATE TABLE IF NOT EXISTS " + FRIEND_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,FRIENDNAME TEXT NOT NULL)");
        Log.e("database", "database table"+FRIEND_TABLE+"created");
    }

   /* public void createFriendTable() {

    }*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS directory");

    }


    public boolean insertData(String emailid, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, emailid);
        contentValues.put(COL_3, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;

        else
            return true;
    }

    public boolean checkUser(String emailid, String password) {


        // array of columns to fetch
        String[] columns = {
                COL_1
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COL_2 + " = ?" + " AND " + COL_3 + " = ?";

        // selection arguments
        String[] selectionArgs = {emailid, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;

    }


    public int isaddFriend(FriendlistModel friendlistModel) {


        //createFriendTable();
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_4, friendlistModel.getFriendname());

        // Inserting Row



        long rowInserted = db.insert(FRIEND_TABLE, null, values);
        if(rowInserted != -1) {
            return 1;
        }
        else {
            return 0;
        }

        //db.close();
    }
    public Cursor getAllData() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }

}
