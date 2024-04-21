package org.example;

class MyRunnable implements Runnable {
    
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main2 {
    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        //myRunnable.run();
        Thread thread = new Thread(myRunnable);
        thread.start();

        
    }
}
