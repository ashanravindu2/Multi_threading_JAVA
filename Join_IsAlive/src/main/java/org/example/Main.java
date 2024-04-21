package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 1 ; i <= 5 ; i++){
                System.out.println("Thread ONE "+ i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 1 ; i <= 5 ; i++){
                System.out.println("Thread TWO "+ i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

            t1.start();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            t2.start();
        System.out.println("Thread ONE and Thread TWO are alive: "+t1.isAlive()+" "+t2.isAlive());
            t1.join();
            t2.join();
            System.out.println("Thread ONE and Thread TWO are alive: "+t1.isAlive()+" "+t2.isAlive());
    }
}