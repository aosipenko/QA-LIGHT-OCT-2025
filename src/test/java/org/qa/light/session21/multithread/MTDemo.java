package org.qa.light.session21.multithread;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MTDemo {

    private static final Random random = new Random();

    @Test
    public void multithreadTest() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(random.nextInt(100));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.interrupt();
        t2.join();
        System.out.println("done!");
    }

    @Test
    public void multithreadTest2() throws InterruptedException {
        Runnable r1 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(random.nextInt(100));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        SomeObj so = new SomeObj();

        Runnable r3 = new Runnable() {
            @Override
            public void run() {

            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("done!");
    }

    @Test
    public void multithreadTest3() throws InterruptedException {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stringList.add(RandomStringUtils.insecure().nextAlphabetic(20));
        }
        AtomicInteger letterACounter = new AtomicInteger(0);
        stringList.parallelStream().forEach(string -> {
            letterACounter.getAndAdd(string.split("a").length);
        });
        System.out.println(letterACounter.get());
    }

    @Test
    public void multithreadTest4() throws InterruptedException {
        String s = "token";
        synchronized (s) {

        }
    }

    private synchronized void smth(){

    }
}
