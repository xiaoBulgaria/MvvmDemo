package com.example;

public class Sync {
    public void test() {
        synchronized (com.sun.corba.se.impl.orbutil.concurrent.Sync.class) {
            System.out.println("test  begin..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test  end..");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread();
            thread.start();
        }
    }
}
    class MyThread extends Thread {
        public void run() {
            Sync sync = new Sync();
            sync.test();
        }
    }





