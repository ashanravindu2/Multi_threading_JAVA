package org.example;

class Q{
    int num;
    boolean value = false;

    public synchronized void put(int num){

        while (value){
            //wait
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("PUT : "+ num);
        this.num=num;
        value=true;
        //notify
        notify();
    }
    public synchronized void get(){

        while (!value){
            //wait
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("GET : "+ num);
        value=false;
        //notify
        notify();

    }
}
class Producer implements Runnable{

    Q q;

    public Producer(Q q){
        this.q=q;
        Thread t1 = new Thread(this,"Producer");
        t1.start();
    }

    @Override
    public void run() {
       int i = 0;
       while (true){
           q.put(i++);

           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }
}


class Consumer implements Runnable{

    Q q;

    public Consumer(Q q){
        this.q=q;
        Thread t1 = new Thread(this,"Consumer");
        t1.start();
    }

    @Override
    public void run() {
        /*int i = 0;
        while (true){
            q.put(i++);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }*/
        while (true){

            q.get();
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

        Q q = new Q();
        new Producer(q);
        new Consumer(q);

    }
}