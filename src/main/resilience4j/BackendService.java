package resilience4j;

public class BackendService {
    public String doSomething() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException();
//        return "doSomething";
    }
}
