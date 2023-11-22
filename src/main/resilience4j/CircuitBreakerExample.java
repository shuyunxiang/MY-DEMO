package resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CircuitBreakerExample {

    public static void main(String[] args) {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(1) // 失败率阈值，超过该阈值将打开熔断器
                .waitDurationInOpenState(Duration.ofMillis(1000)) // 在打开状态下等待的时间
                .permittedNumberOfCallsInHalfOpenState(2) // 半开状态下允许的最大调用次数
                .slidingWindowSize(2) // 滑动窗口的大小
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .build();

        CircuitBreaker circuitBreaker = CircuitBreaker.of("myCircuitBreaker", config);

        // 模拟请求失败
        for (int i = 0; i < 100; i++) {
            if (circuitBreaker.getState().equals(CircuitBreaker.State.OPEN)) {
                System.out.println("Circuit Breaker is open: " + i);
            } else {
                try {
                    if (i == 20 || i == 21) {
                        circuitBreaker.onError(0, TimeUnit.SECONDS, new RuntimeException("Simulated error"));
                    }
                } catch (Exception e) {
                    // 处理异常
                }
            }
        }
    }
}