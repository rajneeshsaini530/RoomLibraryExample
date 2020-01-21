package com.rj.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract MyDao getDao();

    public static MyDatabase myDatabase;

    public static MyDatabase getMyDatabase(Context context){
        if(myDatabase==null){
            myDatabase = Room.databaseBuilder(context,MyDatabase.class,"UserDatabase").build();
        }
        return myDatabase;
    }

}
