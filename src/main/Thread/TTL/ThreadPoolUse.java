package Thread.TTL;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUse {
    public static void main(String[] args) {

        TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();
        context.set("value-set-in-parent");

        // 修饰线线程池
        ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newCachedThreadPool());

        // runnable正常使用
        Runnable runnable = () -> {
            System.out.println(context.get());
        };
        executorService.submit(runnable);

        // callable正常使用
        Callable<String> callable = new Callable<>() {
            @Override
            public String call() throws Exception {
                System.out.println(context.get());
                return null;
            }
        };
        executorService.submit(callable);

    }
}
