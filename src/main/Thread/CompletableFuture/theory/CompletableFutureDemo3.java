package Thread.CompletableFuture.theory;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture原理示例
 */
public class CompletableFutureDemo3 {
    public static void main(String[] args) throws Exception {

        CompletableFuture<String> base = new CompletableFuture<>();

        // 这里开始完成任务,后序的任务进去,会直接弹栈,顺序和代码顺序相同
        base.complete("start");

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

        // 这里开始完成任务,后序的任务都已经在栈中,所以执行的时候是逆序
        base.complete("start");

    }
}
