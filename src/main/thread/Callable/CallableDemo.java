package thread.Callable;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        CallableHandle callableHand = new CallableHandle();
        Future<Data> submit = executorService.submit(callableHand);

        System.out.println(submit.get().age);
    }
}

class Data {
    String name;
    Integer age;
}

class CallableHandle implements Callable {
    @Override
    public Object call() throws Exception {
        Data data = new Data();
        data.name = "SHU_YUN_XIANG";
        data.age = 1;
        return data;
    }
}