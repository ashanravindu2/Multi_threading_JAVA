package org.example;

class  One extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread ONE"+i);
            //thread is sleep

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class  Two extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread TWO"+i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}


public class Main {
    public static void main(String[] args) {
        One one = new One();
        Two two = new Two();
        one.start();
        two.start();
    }
}