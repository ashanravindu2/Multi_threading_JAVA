package org.example;

class Mythread extends Thread {
   public  void run() {
       System.out.println("My first thread is running");
   }
}
public class Main {
    public static void main(String[] args) {

        Mythread thread1 = new Mythread();
        thread1.start();
    }
}
