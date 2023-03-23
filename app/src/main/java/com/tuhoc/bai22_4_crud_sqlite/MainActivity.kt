package com.tuhoc.bai22_4_crud_sqlite

import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var db: SQLiteDatabase
    lateinit var rs : Cursor
    lateinit var adapter: SimpleCursorAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var helper = MyHelper(applicationContext)
        db = helper.readableDatabase

        var button1 = findViewById<Button>(R.id.btnInsert)
        var edtUser = findViewById<EditText>(R.id.edtUser)
        var edtEmail = findViewById<EditText>(R.id.edtEmail)
        var edtpass = findViewById<EditText>(R.id.edtpass)


        button1.setOnClickListener {
            var cv = ContentValues()
            cv.put("user", edtUser.text.toString())
            cv.put("email", edtEmail.text.toString())
            cv.put("pass", edtpass.text.toString())
            db.insert("DANGKY", null, cv)
            rs.requery()
            adapter.notifyDataSetChanged()
            var ad = AlertDialog.Builder(this)
            ad.setTitle("Add record")
            ad.setMessage("Add thành công")
            ad.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                edtUser.setText("")
                edtEmail.setText("")
                edtUser.requestFocus()
            })
            ad.show()


        }
    }


}