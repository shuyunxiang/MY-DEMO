package Thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 异步基础使用
 */
public class CompletableFutureDemo3 {
    public static void main(String[] args) throws Exception {

        CompletableFuture<String> base = new CompletableFuture<>();

        CompletableFuture<String> completion0 = base.thenApply(s -> {
            System.out.println("completion 0");
            return s + " 0";
        });

        CompletableFuture<String> completion1 = base.thenApply(s -> {
            System.out.println("completion 1");
            return s + " 1";
        });

        CompletableFuture<String> completion2 = base.thenApply(s -> {
            System.out.println("completion 2");
            return s + " 2";
        });

        completion1.thenApply(s -> {
            System.out.println("completion 3");
            return s + " 3";
        });
        completion1.thenApply(s -> {
            System.out.println("completion 4");
            return s + " 4";
        });
        completion1.thenApply(s -> {
            System.out.println("completion 5");
            return s + " 5";
        });


        completion2.thenApply(s -> {
            System.out.println("completion 6");
            return s + " 6";
        });
        completion2.thenApply(s -> {
            System.out.println("completion 7");
            return s + " 7";
        });
        completion2.thenApply(s -> {
            System.out.println("completion 8");
            return s + " 8";
        });

        base.complete("start");
    }
}
