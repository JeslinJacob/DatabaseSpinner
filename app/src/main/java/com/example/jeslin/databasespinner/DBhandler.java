package com.example.jeslin.databasespinner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JeSLiN on 22-06-2017.
 */

public class DBhandler extends SQLiteOpenHelper {
    private static final String DBname="students";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="sname";
    private static final String TABLE_NAME="NamesTable";
    public DBhandler(Context context) {
        super(context,DBname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createquery="CREATE TABLE "+TABLE_NAME+"("+KEY_ID+" INTEGER PRIMARY KEY , "+KEY_NAME+" TEXT)";
        db.execSQL(createquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public void addnames(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,name);
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public List<String> getallnames(){
        SQLiteDatabase db=this.getWritableDatabase();
        List<String> nameList=new ArrayList<String>();
        String query="select * from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        if (cursor.moveToFirst())
        {
            do {
                nameList.add(cursor.getString(1));
                Log.d("msg0 ",cursor.getString(1));
            }while (cursor.moveToNext());
        }

        return nameList;
    }
}
