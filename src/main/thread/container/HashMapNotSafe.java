package thread.container;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * HashMap不安全测试
 */
public class HashMapNotSafe {

    public static void main(String[] args) {
        final Map<Integer, String> map = new HashMap<>();

        final Integer targetKey = 0b1111_1111_1111_1111; // 65 535
        final String targetValue = "v";
        map.put(targetKey, targetValue);

        new Thread(() -> {
            IntStream.range(0, targetKey).forEach(key -> map.put(key, "someValue"));
        }).start();

        // 扩容copy这里会取到空，说明线程中无法保证安全，有值为空
        while (true) {
            if (null == map.get(targetKey)) {
                throw new RuntimeException("HashMap is not thread safe.");
            }
        }
    }
}
