package com.suek.nyamnyam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class BookmarkActivity extends AppCompatActivity {

    ArrayList<BookmarkItems> items= new ArrayList<>();
    BookmarkAdapter adapter;
    RecyclerView recyclerView;


    SQLiteDatabase db;
    //String dbName= "bookmark.db";
    String tableName= "bookmarkItems";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        adapter= new BookmarkAdapter(this, items);
        recyclerView= findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);



        db= openOrCreateDatabase("bookmark.db", MODE_PRIVATE, null);


        Cursor cursor= db.rawQuery("SELECT * FROM "+ tableName, null);

        //if(cursor==null) return;  //값이 없으면 종료

        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext()){
            String foodImg= cursor.getString(cursor.getColumnIndex("foodImg"));
            String foodTitle= cursor.getString(cursor.getColumnIndex("foodTitle"));
            String foodSub= cursor.getString(cursor.getColumnIndex("foodSub"));
            int fav= cursor.getInt(3); //[3]번방 콜룸

            buffer.append(foodImg+""+foodTitle+""+foodSub+""+fav);
        }

        Toast.makeText(this, buffer.toString(), Toast.LENGTH_SHORT).show();



    }
}
