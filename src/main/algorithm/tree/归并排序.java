package algorithm.tree;

public class 归并排序 {

    private static int[] temp;

    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    // 递归分解
    private void sort(int[] nums, int begin, int end) {
        if (begin == end) {
            return;
        }
        int mid = (begin + end) / 2;
        sort(nums, begin, mid);
        sort(nums, mid + 1, end);
        merge(nums, begin, mid, end);
    }

    // 合并子数组
    private void merge(int[] nums, int begin, int mid, int end) {
        for (int i = begin; i <= end; i++) {
            temp[i] = nums[i];
        }

        // 数组双指针技巧，合并两个有序数组
        int i = begin;
        int j = mid + 1;
        for (int p = begin; p <= end; p++) {
            if (i == mid + 1) {
                // 左半边数组已全部被合并
                nums[p] = temp[j++];
            } else if (j == end + 1) {
                // 右半边数组已全部被合并
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }


        }
    }
}
