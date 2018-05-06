package com.sruly.stu.ezralezaivaldhadafuk;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by stu on 5/6/2018.
 */

public class ContactVH extends RecyclerView.ViewHolder {
    TextView nameView, yearView;
    Button editBtn;
    public ContactVH(View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.all_contacts_rv_row_name);
        yearView = itemView.findViewById(R.id.all_contacts_rv_row_birth_year);
        editBtn = itemView.findViewById(R.id.all_contacts_rv_row_edit_btn);
    }

    public void update(Contact contact) {
        nameView.setText(contact.getName());
        yearView.setText("" + contact.getBirthYear());
    }
}
