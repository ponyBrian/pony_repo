package com.atguigu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


    class Ticket{
        private int number = 50;
        Lock lock = new ReentrantLock(true);
        public void sale()
        {
            lock.lock();
            try
            {
                if(number >0 )
                {
                    System.out.println( Thread.currentThread().getName() + "\t" + "sold No." + (number--) + "\tstill remaining: " + number );
                    //try { TimeUnit.MILLISECONDS.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            }finally {

                lock.unlock();
            }
        }
    }


public class JUCVersion {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread ( () -> { for ( int i = 0; i < 50; i++ ) { ticket.sale(); } }, "Seller No.1" ).start();
        new Thread ( () -> { for ( int i = 0; i < 50; i++ ) { ticket.sale(); } }, "Seller No.2" ).start();
        new Thread ( () -> { for ( int i = 0; i < 50; i++ ) { ticket.sale(); } }, "Seller No.3" ).start();
    }
}

