package com.tuhoc.bai22_4_crud_sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context) :SQLiteOpenHelper(context,"TUHOCDB",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE DANGKY(_id integer primary key autoincrement,user TEXT, email TEXT,pass TEXT)")

        db?.execSQL("Insert into DANGKY(user,email,pass) values ('mot','mot@gmail.com','123')")
        db?.execSQL("Insert into DANGKY(user,email,pass) values ('hai','hai@gmail.com','123')")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newSVersion: Int) {
        TODO("Not yet implemented")
    }
}
