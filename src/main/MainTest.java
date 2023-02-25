package main;

import com.alibaba.ttl.TransmittableThreadLocal;

public class MainTest {
    public static void main(String[] args) {
        TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();

        // 在父线程中设置
        context.set("value-set-in-parent");

        // 在子线程中可以读取，值是"value-set-in-parent"
        String value = context.get();

        System.out.println(value);
    }
}
