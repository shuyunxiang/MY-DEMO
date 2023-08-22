package Basic.Static;

/**
 *
 */
public class StaticFeature {

    private static Integer num1 = 1;
    private static int num2 = 1;

    public void plus1() {
        num1 = num1 + 1;
    }

    public void plus2() {
        num2 = num2 + 2;
    }

    public void showNum() {
        System.out.println("num1:" + num1);
        System.out.println("num2:" + num2);
    }
}
