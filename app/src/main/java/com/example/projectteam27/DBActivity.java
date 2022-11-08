package com.example.projectteam27;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
public class DBActivity extends AppCompatActivity {
    EditText mName;
    EditText mPhone;
    ListView mDBView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);
        mName = (EditText) findViewById(R.id.text_name);
        mPhone = (EditText) findViewById(R.id.text_phone);
        mDBView = (ListView) findViewById(R.id.dbview);
    }
    public void onInsert(View view) {
        ContentValues values  = new ContentValues();
        values.put(ContactsDatabase.ID,new Random().nextInt(100));
        values.put(ContactsDatabase.NAME,mName.getText().toString());
        values.put(ContactsDatabase.PHONE,mPhone.getText().toString());

        getApplicationContext().getContentResolver().insert(ContactsContentProvider.CONTENT_URI,values);
        Toast.makeText(this,"Insert 1 row",Toast.LENGTH_SHORT).show();
        onShow(view);
    }
    public void onClear(View view) {
        int delcount =
                getContentResolver().delete(ContactsContentProvider.CONTENT_URI,null,null);
        Toast.makeText(this,"Delete " + delcount +
                "rows",Toast.LENGTH_SHORT).show();
        onShow(view);
    }
    public void onShow(View view) {
        Uri uri = ContactsContentProvider.CONTENT_URI;
        Cursor cursor = this.getContentResolver().query(uri,null,null,null,null);
        StringBuilder sb = new StringBuilder();
        ArrayList<String> clickeddata=new ArrayList<String>();
        while (cursor.moveToNext()){
            sb.append(cursor.getString(0) + ",");
            sb.append(cursor.getString(1) + ",");
            sb.append(cursor.getString(2) + ",");
            sb.append("\n");
        }

        clickeddata.add(sb.toString());
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clickeddata);
        mDBView.setAdapter(adapter);
    }
}