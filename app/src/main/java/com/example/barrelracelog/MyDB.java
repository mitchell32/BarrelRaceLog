package com.example.barrelracelog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by mitch on 4/20/2017.
 */

public class MyDB {
    private MyDB(){}

    public static class Arena implements BaseColumns {
        public static final String TABLE_NAME = "arena";
        public static final String ARENA_NAME = "arena";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ARENA_NAME + ")";
    }

}
