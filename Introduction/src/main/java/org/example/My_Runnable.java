package org.example;

public class My_Runnable implements  Runnable{

    private String name ;

    public My_Runnable(String name) {
        this.name = name;
    }




    @Override
    public void run() {
        System.out.println("Start Thred : "+ name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End Thred : "+ name);
    }
}
