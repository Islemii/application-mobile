package com.example.testapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "testapplication.db";
    private static final int DATABASE_VERSION = 1 ;
    private static final String TABLE_NAME = "clients";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_FNAME = "fullname";
    private static final String COLUMN_MAIL = "mail";
    private static final String COLUMN_PWD = "password";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_FNAME + " TEXT, " +
                        COLUMN_MAIL + " TEXT, " +
                        COLUMN_PWD + " TEXT) ;";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);


    }
    void addClient(String fname, String email, String pwd){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FNAME,fname);
        cv.put(COLUMN_MAIL,email);
        cv.put(COLUMN_PWD,pwd);
        long result = db.insert(TABLE_NAME,null,cv);
        if (result == -1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added successfully !",Toast.LENGTH_SHORT).show();
        }

    }
}
