package Thread.Callable.callbackhell;

public class Boss implements Callback<String>{

    @Override
    public void callBack(String s) {
        System.out.println(s.concat("完成"));
        System.out.println("表扬做的不错");
    }

}
