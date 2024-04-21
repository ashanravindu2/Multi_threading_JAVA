package org.example;


class Calculate {
    int num;

    public synchronized void increment() { // IMPORTANT sysnchronized
        // keyword is used to make sure that only one thread can access this method at a time
        num++;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // print 0 to 2000 using 2 thread
        Calculate calculate = new Calculate();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                calculate.increment();
              //  System.out.println("Thread ONE: " + calculate.num);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                calculate.increment();
              //  System.out.println("Thread TWO: " + calculate.num);
            }
        });


    /*    t1.start();
        t1.join();
        t2.join();
        t2.start();*/

        t1.start();
        t1.join();
        t2.start();
        t2.join();



        System.out.println("Value of num: " + calculate.num);

    }
}