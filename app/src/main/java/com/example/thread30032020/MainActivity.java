package com.example.thread30032020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // background thread
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB","hello");
            }
        });

        thread.start();

        // Kiem tra vong doi cua thread
        Log.d("BBB",thread.getState().toString());

    }
}