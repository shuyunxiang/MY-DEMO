package algorithm.tree;

public class 凑零钱 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] coins = new int[]{1,2,5};
        int amount = 16;

        int coinNum = solution.coinChange(coins, amount);
        System.out.println(coinNum);
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = coinChange(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
