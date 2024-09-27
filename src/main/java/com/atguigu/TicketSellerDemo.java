package com.atguigu;

//口诀：高内聚，低耦合，线程；操作；资源类
//three seller，sold tickets，50 pieces

import java.util.concurrent.TimeUnit;

//create resource
class TicketsSold // Object = Attribute(Filed) + method
{
    private int Ticketnumber = 50; //number of Tickets ; this is the field (Attribute)


    // operation of sale tickets ; this is the method ,the 'synchronized' as a locker to make sure there will be no error on tickets
    public synchronized void sale()
    {
        if(Ticketnumber > 0)
        {
            System.out.println(Thread.currentThread().getName() + "\t" + "the number of ticket: " + (Ticketnumber--) + " is sold; " + "\t Remaining tickets are: " + Ticketnumber);

            //in there we can also use the time space for 10 or longer seconds to check the seller No.? is really working or not

            /*try{
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {e.printStackTrace();}*/
        }
    }
}

public class TicketSellerDemo {

    public static void main(String[] args) {

        //three seller, therefore three threads
        /*Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        Thread thread3 = new Thread();*/

        //API of Thread constructor: "Thread(Runnable target, String name)" ; Allocates a new Thread object

        TicketsSold ticketsSold = new TicketsSold();


        //Anonymous inner classes interface can be new!    new 'Runnable' interface for the Anonymous inner class
        new Thread(new Runnable() {
            @Override
            public void run() {
                //make sure the number of tickets will not be over than max number of 50
                for (int i = 0; i < 50; i++) {
                    ticketsSold.sale();

                }
            }
        }, "Seller No.1").start();

//---------------------------------------------------
        new Thread(new Runnable() {
            @Override
            public void run() {
                //make sure the number of tickets will not be over than max number of 50
                for (int i = 0; i < 50; i++) {
                    ticketsSold.sale();

                }
            }
        }, "Seller No.2").start();

//----------------------------------------------------
        new Thread(new Runnable() {
            @Override
            public void run() {
                //make sure the number of tickets will not be over than max number of 50
                for (int i = 0; i < 50; i++) {
                    ticketsSold.sale();

                }
            }
        }, "Seller No.3").start();

    }
}
