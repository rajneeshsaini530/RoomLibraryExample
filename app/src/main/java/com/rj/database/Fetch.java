package com.rj.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Fetch extends AppCompatActivity {

    TextView textView;
    MyDatabase myDatabase;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);

        textView = findViewById(R.id.user_data);
        myDatabase = MyDatabase.getMyDatabase(this);

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<User> list= myDatabase.getDao().getUsers();
                for(int i=0;i<list.size();i++){
                    User user = list.get(i);
                    data = data+""+user.getId()+" "+user.getName()+" "+user.getEMail()+"\n";
                }

                textView.setText(data);

            }
        });

    }
}
