package Thread.CompletableFuture.theory;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 异步基础使用
 */
public class CompletableFutureDemo2 {
    public static void main(String[] args) throws Exception {
        // 异步执行
        CompletableFuture
                .supplyAsync(new Supplier<Integer>() {
                                          @Override
                                          public Integer get() {
                                              try {
                                                  Thread.sleep(100);
                                              } catch (InterruptedException e) {
                                                  throw new RuntimeException(e);
                                              }
                                              System.out.println(Thread.currentThread().getName());
                                              return 1;
                                          }
                                      }

                )
                .thenAccept(new Consumer<Integer>() {
                                @Override
                                public void accept(Integer integer) {
                                    System.out.println(Thread.currentThread().getName());
                                    System.out.println(integer);
                                }
                            }
                );

        System.out.println("主线程执行1");
        Thread.sleep(2000);
        System.out.println("主线程执行2");
    }
}
