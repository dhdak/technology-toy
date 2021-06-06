package com.weizihe.algorithm;

/**
 * 两个线程交替打印12345
 *
 * @author weizihe
 * @date 2021-05-26 23:28
 */
public class TwoThreadPrient {

    private static volatile int i = 1;
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {

        new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("thread1 is:"+ i);
                    i++;
                    lock1.notify();
                    try {
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("thread2 is:"+i);
                    i++;
                    lock1.notify();
                    try {
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }

        }).start();


//        new Thread(()->{
//            while (true) {
//                if (i > 5) {
//                    i=1;
//                }
//
//                if (i == 1 || i == 3 || i == 5) {
//                    System.out.println(i);
//                    i++;
//                }
//                try {
//                    Thread.sleep(100L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
//
//        new Thread(()->{
//            while (true) {
//
//                if (i == 2 || i == 4) {
//                    System.out.println(i);
//                    i++;
//                }
//
//                try {
//                    Thread.sleep(210L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
    }

}
