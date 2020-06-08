package com.example.thread30032020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a , b , c;
    MyFlag myFlag = new MyFlag(0);
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
                synchronized (myFlag){
                    for (int i = 0; i <= 10 ; ) {
                        if (myFlag.index == 0){
                            a = i;
                            Log.d("BBB","A : "+ i++);
                            myFlag.index = 1;
                            myFlag.notifyAll();
                        }else{
                            try {
                                myFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag){
                    for (int i = 0; i <= 10 ;) {
                        if (myFlag.index == 1){
                            b = i;
                            Log.d("BBB","B : "+ i++);
                            myFlag.index = 2;
                            myFlag.notifyAll();
                        }else{
                            try {
                                myFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag){
                    for (int i = 0; i <= 10 ;) {
                        if (myFlag.index == 2){
                            c = a + b;
                            Log.d("BBB","C : "+ c);
                            myFlag.index = 0;
                            i++;
                            myFlag.notifyAll();
                        }else{
                            try {
                                myFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        threadC.start();
        threadA.start();
        threadB.start();
    }

    // Xu ly dong bo
//    private synchronized void showName(String name) {
//        for (int i = 0; i <= 1000; i++) {
//            Log.d("BBB", name + " : " + i);
//        }
//    }
}