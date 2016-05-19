package com.example.ariel.ormlite.dbhelpers;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by ariel on 19/5/2016.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    public static  void  main (String[] args) throws SQLException,IOException{
        writeConfigFile("ormlite_config.txt");
    }
}
