package org.example;

class One implements Runnable{
    public void run() {
        for (int i = 1 ; i <= 5 ; i++){
            System.out.println("Thread ONE "+ i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Two implements Runnable{
    public void run() {
        for (int i = 1 ; i <= 5 ; i++){
            System.out.println("Thread TWO "+ i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {

        Runnable one = new One();
        Runnable two = new Two();

        Thread t1 = new Thread(one);
        Thread t2 = new Thread(two);

        t1.start();
        t2.start();


    }
}