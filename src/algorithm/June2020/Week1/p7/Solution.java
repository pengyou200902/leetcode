package algorithm.June2020.Week1.p7;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-07 21:47
 * @Reference https://leetcode.com/problems/coin-change-2/discuss/99222/Video-explaining-how-dynamic-programming-works-with-the-Coin-Change-problem
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int coin: coins) {
            for(int i = coin; i <= amount; i++) {
                if (i >= coin)
                    dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {

    }
}
