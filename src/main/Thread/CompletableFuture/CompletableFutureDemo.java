package Thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        GetUser getUser = new GetUser();

        CompletableFuture completableFuture = CompletableFuture.supplyAsync(getUser);

        // 同步获取返回值
//        User user = (User)completableFuture.get();
//        System.out.println(user.name);
//        System.out.println(user.age);

        // 完成后续操作(不变值)
//        User userResult = (User)completableFuture.whenCompleteAsync(
//                (result, error) -> {
//                    User user = (User) result;
//                    System.out.println(user.name);
//
//                }).get();
//        System.out.println(userResult.name);
//        System.out.println(userResult.age);

        // 完成后续操作(可自定义值)
//        Integer age = (Integer)completableFuture.handle((result, error) -> {
//            User user = (User) result;
//            return user.age;
//        }).get();
//        System.out.println(age);

    }
}

class GetUser implements Supplier {
    @Override
    public Object get() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        User user = new User();
        user.age = 30;
        user.name = "shuyunxiang";
        return user;
    }
}

class GetAccountBalance implements Supplier {
    @Override
    public Object get() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 10086;
    }
}

class User{
    String name;
    int age;
}