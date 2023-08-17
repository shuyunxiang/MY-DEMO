package Thread.TTL;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableAndCallableUse {
    public static void main(String[] args) {
        TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();
        context.set("value-set-in-parent");

        ExecutorService executorService = Executors.newCachedThreadPool();

        /*
        这里实际上是 InheritableThreadLocal 的效果，只会在线程创建的那一刻传递父值。
        线程池的复用，就无法获得父值。
         */
        Runnable runnable0 = () -> {
            System.out.println(context.get());
        };
        executorService.submit(runnable0);

        /*
        修饰任务
         */
        Runnable runnable1 = () -> System.out.println(context.get());
        TtlRunnable ttlRunnable1 = TtlRunnable.get(runnable1);
        executorService.submit(ttlRunnable1);
    }
}
