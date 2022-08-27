package jvm;

/**
 * Java虚拟机垃圾回收测试
 */
public class GCtest {

    public static void main(String[] args) {
        // 测试新对象优先
//        testAllocation();

        // 测试大对象直接进入永久代
//        testPretenureSizeThreshold();

        // 多次存活对象进入老年代
        testTenuringThreshold();

    }

    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     * -Xms20M 最小堆内存
     * -Xmx20M 最大堆内存
     * -Xmn10M 新生代内存
     * -XX:+PrintGCDetails 打印详细GC日志
     * -XX:SurvivorRatio=8 eden/survivor比率
     * -XX:+UseSerialGC 指定垃圾内存回收器
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        // 出现一次Minor GC
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
     * -XX:PretenureSizeThreshold=3145728 定义大对象
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];  //直接分配在老年代中
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
     * -XX:MaxTenuringThreshold=1 多少次存活进入老年代
     * -XX:+PrintTenuringDistribution 幸存区域年纪分布
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        // 256KB什么时候进入老年代决定于XX:MaxTenuringThreshold设置
        allocation1 = new byte[_1MB / 4];
        // 4048KB
        allocation2 = new byte[4 * _1MB];
        // 4048KB Eden区占用 8352KB->第一次GC
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        // 第二次GC
        allocation3 = new byte[4 * _1MB];
    }
}
