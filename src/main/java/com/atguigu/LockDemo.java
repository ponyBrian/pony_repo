package com.atguigu;

import java.util.concurrent.TimeUnit;

class Phone{
    public synchronized void sendEmail(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {e.printStackTrace();}
        System.out.println("----come in sendEmail");
    }

    public synchronized void sendSMS(){
        System.out.println("----come in SMS");
    }

    public void hello(){
        System.out.println("----hello");
    }
}


public class LockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        /*Phone phone2 = new Phone();*/

        new Thread(() -> {phone.sendEmail();},"t1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {e.printStackTrace();}

        new Thread(() -> {phone.sendSMS();},"t2").start();


    }
}
