package com.rj.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    EditText id, name, email;
    MyDatabase myDatabase;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        myDatabase = MyDatabase.getMyDatabase(this);
    }

    public void submit(View view) {
        String userId = id.getText().toString();
        String userName = name.getText().toString();
        String userEmail = email.getText().toString();


         user = new User(userId,userName,userEmail);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {

                long data = myDatabase.getDao().insertUser(user);

            }
        });



    }

    public void fetch(View view) {
        startActivity(new Intent(this,Fetch.class));
    }

    public void delete(View view) {

        String userId = id.getText().toString();
        String userName = name.getText().toString();
        String userEmail = email.getText().toString();


        user = new User(userId,userName,userEmail);

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {

                myDatabase.getDao().deleteUser(user);

            }
        });

    }

    public void update(View view) {

        String userId = id.getText().toString();
        String userName = name.getText().toString();
        String userEmail = email.getText().toString();


        user = new User(userId,userName,userEmail);

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {

                myDatabase.getDao().updateUser(user);

            }
        });
    }
}
