package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {

    public static void main(String[] args) throws Exception {

        // 接口和继承方式
        new Thread(new RunnableThread("接口线程")).start();
        new ExtendsThread("继承线程").start();

//        // 线程池方式
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        // 先执行异步
//        Future<Integer> submit1 = service.submit(new CallableTask1());
//        Future<Integer> submit2 = service.submit(new CallableTask2());
//        // 阻塞获取
//        System.out.println(submit1.get());
//        System.out.println(submit2.get());
//        service.shutdown();

    }

}

class RunnableThread implements Runnable {

    private String threadName;

    @Override
    public void run() {
        System.out.println(threadName);
    }

    public RunnableThread(String threadName) {
        this.threadName = threadName;
    }
}

class ExtendsThread extends Thread {

    private String threadName;

    @Override
    public void run() {
        System.out.println(threadName);
    }

    public ExtendsThread(String threadName) {
        this.threadName = threadName;
    }
}

class CallableTask1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("我是第1个线程");
        Thread.sleep(1000);
        return 1;
    }

    public CallableTask1() {
        System.out.println("第1个线程被构造");
    }
}

class CallableTask2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("我是第2个线程");
        return 2;
    }

    public CallableTask2() {
        System.out.println("第2个线程被构造");
    }
}