package Thread.Callable.callbackhell;

public class Worker {

    public void work(String someWork,Callback<String> boss ) {
        String result = someWork.concat("完成"); // 做一些具体的处理
        boss.callBack(result); // 反馈结果给老板


    }

}
