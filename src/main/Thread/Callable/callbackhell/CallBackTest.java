package Thread.Callable.callbackhell;

public class CallBackTest {
    public static void main(String[] args) {

        Callback<String> boss = new Boss();

        Worker worker = new Worker();
        worker.work("端茶倒水",boss);
    }
}
