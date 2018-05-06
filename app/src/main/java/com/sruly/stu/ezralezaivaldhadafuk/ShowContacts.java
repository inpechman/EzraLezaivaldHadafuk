package com.sruly.stu.ezralezaivaldhadafuk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.HashMap;

public class ShowContacts extends AppCompatActivity {
    RecyclerView allContactsRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contacts);
        allContactsRecyclerView = findViewById(R.id.show_all_contacts_rv);
        allContactsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        HashMap<Long, Contact> contactHashMap = DBM.getInstance(getApplicationContext()).loadFromDB();
        allContactsRecyclerView.setAdapter(new ContactsAdapter(getApplicationContext(),contactHashMap));

    }
}
