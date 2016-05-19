package com.example.ariel.ormlite.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.ariel.ormlite.R;
import com.example.ariel.ormlite.entities.Contact;
import com.example.ariel.ormlite.entities.RecordArrayAdapter;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends DatabaseActivity {
    private Button btn_nav_new_contact;
    private ListView listView;
    private List<Contact> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_nav_new_contact = (Button) findViewById(R.id.btn_nav_new_contact);
        btn_nav_new_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddContactActivity.class);
                startActivityForResult(intent,0);
            }
        });
        listView = (ListView) findViewById(R.id.contacts_list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                if (position >= 0 ){
                    Intent intent = new Intent(getApplicationContext(),ContactDetails.class);
                    intent.putExtra("contact",contactList.get(position));
                    startActivityForResult(intent,0);
                }
            }
        });
        populateListView();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        populateListView();
    }
    private void populateListView(){
        try{
            contactList = getContactDao().queryForAll();
            listView.setAdapter(new RecordArrayAdapter(this, R.layout.list_item,contactList));
        }
        catch (SQLException ex){}
    }
}
