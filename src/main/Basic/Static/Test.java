package Basic.Static;

/**
 * 验证static的全局性,不属于某个对象
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        StaticFeature staticDemo0 = new StaticFeature();
        staticDemo0.showNum();

        // 其他线程自增
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                staticDemo0.plus1();
                staticDemo0.plus2();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        // 当前线程自增
        Thread.sleep(1000);
        staticDemo0.plus1();
        staticDemo0.plus2();
        staticDemo0.showNum();

        // 第二个类引用自增
        StaticFeature staticDemo1 = new StaticFeature();
        staticDemo1.plus1();
        staticDemo1.plus2();
        staticDemo1.showNum();
    }
}
