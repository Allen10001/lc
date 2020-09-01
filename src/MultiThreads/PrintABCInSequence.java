package MultiThreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. 使用 CountDownLatch 保证线程执行顺序
 * 2. 使用 CyclicBarrier 保证线程执行顺序
 *
 * 使用场景类似于CountDownLatch与CountDownLatch的区别
 *
 * CountDownLatch主要是实现了1个或N个线程需要等待其他线程完成某项操作之后才能继续往下执行操作，
 * 描述的是1个线程或N个线程等待其他线程的关系。CyclicBarrier主要是实现了多个线程之间相互等待，
 * 直到所有的线程都满足了条件之后各自才能继续执行后续的操作，描述的多个线程内部相互等待的关系。
 * CountDownLatch是一次性的，而CyclicBarrier则可以被重置而重复使用。
 */
public class PrintABCInSequence {

    public static void main(String[] args) throws Exception {
        /**
         * 1. 使用 CountDownLatch 保证线程执行顺序
         */
        /*
       Lock lock = new ReentrantLock();

        for (int i = 0; i < 10; i++) {
            CountDownLatch latch1 = new CountDownLatch(1);
            CountDownLatch latch2 = new CountDownLatch(1);
            CountDownLatch latch3 = new CountDownLatch(1);
            Thread thread1 = new Thread(new Thread1(lock, latch1));
            Thread thread2 = new Thread(new Thread2(lock, latch2));
            Thread thread3 = new Thread(new Thread3(lock, latch3));
            try {
                thread1.start();
                latch1.await();
                thread2.start();
                latch2.await();
                thread3.start();
                latch3.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/

        /**
         * 2. 使用 CyclicBarrier 保证线程执行顺序
         */
        Lock lock = new ReentrantLock();
        CyclicBarrier barrier1 = new CyclicBarrier(1);
        CyclicBarrier barrier2 = new CyclicBarrier(2);
        CyclicBarrier barrier3 = new CyclicBarrier(3);
        CyclicBarrier barrierMain = new CyclicBarrier(2);
        for (int i = 0; i < 10; i++) {

            Thread thread1 = new Thread(new Thread1(lock, barrier1, barrier2, barrier3));
            Thread thread2 = new Thread(new Thread2(lock, barrier2, barrier3));
            Thread thread3 = new Thread(new Thread3(lock, barrier3, barrierMain));
            try {
                thread1.start();
                thread2.start();
                thread3.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            barrierMain.await();
            barrier1.reset();
            barrier2.reset();
            barrier3.reset();
            barrierMain.reset();
        }
    }
}


class Thread3 implements Runnable {

    private Lock lock;
    private CyclicBarrier barrier;
    private CyclicBarrier barrierMain;

    Thread3(Lock lock,  CyclicBarrier barrier, CyclicBarrier barrierMain) {
        this.lock = lock;
        this.barrier = barrier;
        this.barrierMain = barrierMain;
    }

    @Override
    public void run() {
        try {
            barrier.await();
            System.out.print("c");
            barrierMain.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Thread2 implements Runnable {

    private Lock lock;
    private CyclicBarrier barrier;
    private CyclicBarrier barrier3;

    Thread2(Lock lock,  CyclicBarrier barrier, CyclicBarrier barrier3) {
        this.lock = lock;
        this.barrier = barrier;
        this.barrier3 = barrier3;
    }

    @Override
    public void run() {

        try {
            barrier.await();
            System.out.print("b");
            barrier3.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Thread1 implements Runnable {

    private Lock lock;
    private CyclicBarrier barrier;
    private CyclicBarrier barrier2;
    private CyclicBarrier barrier3;

    Thread1(Lock lock,  CyclicBarrier barrier, CyclicBarrier barrier2, CyclicBarrier barrier3) {
        this.lock = lock;
        this.barrier = barrier;
        this.barrier2 = barrier2;
        this.barrier3 = barrier3;
    }

    @Override
    public void run() {
        try {
            barrier.await();
            System.out.print("a");
            barrier2.await();
            barrier3.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
