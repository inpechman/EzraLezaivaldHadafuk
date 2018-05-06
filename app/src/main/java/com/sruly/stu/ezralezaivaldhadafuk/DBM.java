package com.sruly.stu.ezralezaivaldhadafuk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;

/**
 * Created by stu on 5/6/2018.
 */

public class DBM {
    private static DBM instance;
    private Context context;
    private SQLiteDatabase db;

    private DBM(Context context) {
        this.context = context;
        db = context.openOrCreateDatabase("contacts.db", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS all_contacts (name TEXT, birth_year INTEGER)");

    }

    public static DBM getInstance(Context context) {
        if (instance == null) {
            instance = new DBM(context);
        }
        return instance;
    }

    public synchronized void insertContact(Contact contact) {
        String name = contact.getName();
        int year = contact.getBirthYear();
        db.execSQL("INSERT INTO all_contacts VALUES ('" +
                name + "', " +
                year + ")");
    }

    public synchronized HashMap<Long, Contact> loadFromDB() {
        Cursor cursor = db.rawQuery("SELECT rowid, * FROM all_contacts", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                HashMap<Long, Contact> contactHashMap = new HashMap<>();
                do {
                    contactHashMap.put(cursor.getLong(cursor.getColumnIndex("rowid")),
                            new Contact(
                                    cursor.getString(cursor.getColumnIndex("name")),
                                    cursor.getInt(cursor.getColumnIndex("birth_year"))));
                } while (cursor.moveToNext());
                return contactHashMap;
            }
            cursor.close();
        }
        return null;
    }
}
