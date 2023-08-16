package algorithm.tree;

import java.util.Random;

public class 快速排序 {
    public static void main(String[] args) {
        int[] ints = new int[]{5, 4, 6, 8, 1, 7, 3, 2};
        Quick.sort(ints);
    }
}

class Quick {

    public static void sort(int[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = partition(nums, left, right);
        sort(nums, left, p - 1);
        sort(nums, p + 1, right);
    }

    // 对 nums[left..right] 进行切分
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1, j = right;

        while (i <= j) {
            while (i < right && nums[i] <= pivot) {
                i++;
            }
            while (j > left && nums[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private static void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    // 原地交换数组中的两个元素
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
