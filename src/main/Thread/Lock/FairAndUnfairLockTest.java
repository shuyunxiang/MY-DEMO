package Thread.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairLockTest {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        Thread[] thread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        for (int i = 0; i < 10; i++) {
            thread[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Job implements Runnable {

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: 进入线程\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: 离开线程\n", Thread.currentThread().getName());
    }
}

class PrintQueue {

    private final Lock queueLock = new ReentrantLock(true);

    public void printJob(Object document) {

        // 抢锁
        queueLock.lock();
        try {
            long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: 任务1 %d seconds\n",
                    Thread.currentThread().getName(), (duration / 1000));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

        // 再次抢锁
        queueLock.lock();
        try {
            long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: 任务2 %d seconds\n",
                    Thread.currentThread().getName(), (duration / 1000));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }

}