package com.sruly.stu.ezralezaivaldhadafuk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button newContact, showAllContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        genRandData();
        newContact = findViewById(R.id.new_contact_btn);
        showAllContacts = findViewById(R.id.show_contacts_btn);

        newContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditContact.class);
                startActivity(intent);
            }
        });
        showAllContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShowContacts.class);
                startActivity(intent);
            }
        });
    }

    public void genRandData(){
        for (int i = 0; i < 10000; i++) {
            DBM.getInstance(getApplicationContext()).insertContact(new Contact(
                    "" + i,
                    (int) (Math.random()*100+1918)
            ));
        }
    }
}
