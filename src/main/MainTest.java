public class MainTest {
    public static void main(String[] args) {
        System.out.println("测试");
    }

    private static int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sort(nums,0,nums.length-1);
    }

    private void sort(int[] nums, int begin, int end) {
        if (begin == end) {
            return;
        }
        int mid = (begin + end) / 2;
        sort(nums, begin, mid);
        sort(nums, mid + 1, end);
        merge(nums,begin,mid,end);
    }

    private void merge(int[] nums, int begin, int mid, int end) {

    }
}
