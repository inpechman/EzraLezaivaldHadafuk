package com.sruly.stu.ezralezaivaldhadafuk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditContact extends AppCompatActivity {
    EditText nameField, birthYearField;
    Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        nameField = findViewById(R.id.edit_name_field);
        birthYearField = findViewById(R.id.edit_birth_year_field);
        saveBtn = findViewById(R.id.save_contact_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBM.getInstance(getApplicationContext()).insertContact(new Contact(
                        nameField.getText().toString(),
                        Integer.parseInt(birthYearField.getText().toString())
                ));
                finish();
            }
        });
    }
}
