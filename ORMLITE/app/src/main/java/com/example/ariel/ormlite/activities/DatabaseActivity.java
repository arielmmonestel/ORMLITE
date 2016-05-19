package com.example.ariel.ormlite.activities;

import android.support.v7.app.AppCompatActivity;

import com.example.ariel.ormlite.dbhelpers.DatabaseHelper;
import com.example.ariel.ormlite.entities.Contact;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.query.In;

import java.sql.SQLException;

/**
 * Created by ariel on 19/5/2016.
 */
public abstract class DatabaseActivity extends AppCompatActivity {

    protected DatabaseHelper databaseHelper = null;
    protected Dao<Contact,Integer> contactDao;
    private DatabaseHelper getHelper(){
        if(databaseHelper ==null){
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }

    protected Dao <Contact,Integer> getContactDao(){
        try{
            contactDao = getHelper().getContactDao();

        }catch (SQLException ex){

        }
        return contactDao;
    }

}
