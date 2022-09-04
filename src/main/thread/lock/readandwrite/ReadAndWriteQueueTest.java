package thread.lock.readandwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁排队->防止读锁一直抢锁导致读锁饥饿
 */
public class ReadAndWriteQueueTest {

    public static void main(String[] args) throws InterruptedException {
        new Thread(ReadAndWriteQueueTest::read, "Thread-2").start();
        Thread.sleep(200);
        new Thread(ReadAndWriteQueueTest::read, "Thread-4").start();
        Thread.sleep(200);
        new Thread(ReadAndWriteQueueTest::write, "Thread-3").start();
        Thread.sleep(200);
        new Thread(ReadAndWriteQueueTest::read, "Thread-5").start();
    }

    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    private static void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到读锁，正在读取");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            readLock.unlock();
        }
    }

    private static void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到写锁，正在写入");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            writeLock.unlock();
        }
    }

}
