package com.example.thread30032020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a , b , c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = b = c = 0;
        // background thread
//        Thread threada = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                showName("A");
//            }
//        });
//
//        threada.start();
//
//        Thread threadb = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                showName("B");
//            }
//        });
//        threadb.start();


        // ThreadA => Tao ra 1 gia tri A
        // ThreadB => Tao ra 1 gia tri B
        // ThreadC => Tong cua A va B
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10 ; i++) {
                    a = i;
                    Log.d("BBB","A : "+ i);
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10 ; i++) {
                    b = i;
                    Log.d("BBB","B : "+ i);
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10 ; i++) {
                    c = a + b;
                    Log.d("BBB","C : "+ c);
                }
            }
        });
    }

    // Xu ly dong bo
//    private synchronized void showName(String name) {
//        for (int i = 0; i <= 1000; i++) {
//            Log.d("BBB", name + " : " + i);
//        }
//    }
}