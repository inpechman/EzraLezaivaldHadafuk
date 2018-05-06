package com.sruly.stu.ezralezaivaldhadafuk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by stu on 5/6/2018.
 *
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactVH> {
    Context context;
    TextView sumOfRows;
    EditText goToField;
    HashMap<Long, Contact> contactHashMap;
    ArrayList<Long> keysList;

    public ContactsAdapter(Context context, HashMap<Long, Contact> contactHashMap) {
        this.context = context;
        this.contactHashMap = contactHashMap;
        this.keysList = new ArrayList<>(this.contactHashMap.keySet());
    }

    public void addMoreContacts(HashMap<Long, Contact> contactHashMap){
        this.contactHashMap.putAll(contactHashMap);
        this.keysList = new ArrayList<Long>(this.contactHashMap.keySet());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.show_contacts_rv_row, null);
        View p = ((View) parent).getRootView();
        goToField = p.findViewById(R.id.go_to_field);
        sumOfRows = p.findViewById(R.id.sum_of_rows);
        return new ContactVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactVH holder, int position) {
        holder.update(contactHashMap.get(keysList.get(position)));
        Log.d("aaaa", "onBindViewHolder: " + keysList.get(position));
        sumOfRows.setText("" + getItemCount());
        goToField.setText("" + position);
    }

    @Override
    public int getItemCount() {
        return keysList.size();
    }
}
