package Thread.Lock.readandwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLockTest {

    public static void main(String[] args) throws InterruptedException {
        new Thread(ReadAndWriteLockTest::read).start();
        new Thread(ReadAndWriteLockTest::read).start();
        new Thread(ReadAndWriteLockTest::write).start();
        new Thread(ReadAndWriteLockTest::write).start();
    }

    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);
    private static final ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    private static void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到读锁，正在读取");
            Thread.sleep(500);
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
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            writeLock.unlock();
        }
    }

}
