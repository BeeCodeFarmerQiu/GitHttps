package com.atqiu;

/**
 * @author 邱建伟
 * @create 2020-05-23 19:37
 */
public class MyRunnable implements Runnable {
    private static int count = 1;
    public void run(){
        while (count<=100) {
            try {
                show();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized  void show() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "打印了" + count);
        count++;
        notify();
        wait();
    }
}
class Test{
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        t1.start();
        t2.start();
    }
}
