package algorithm.June2020.Week1.p3;

import java.util.Arrays;

/**
 * Two City Scheduling
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
 * and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 * Example 1:
 *
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 *
 * Note:
 *
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 *
 * @Author Friende.Peng_You
 * @Date 2020-06-04 22:11
 * @Reference https://leetcode.com/problems/two-city-scheduling/discuss/278731/Java-DP-Easy-to-Understand
 */
public class DPSolution {
    public static int twoCitySchedCost(int[][] costs) {
        int N = costs.length / 2;
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int j = 1; j <= N; j++) {
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }
        System.out.println("2for ------ :");
        System.out.printf("dp -> ");
        for (int[] x: dp) {
            System.out.println(Arrays.toString(x));
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        System.out.println("before return ------ :");
        System.out.printf("dp -> ");
        for (int[] x: dp) {
            System.out.println(Arrays.toString(x));
        }
        return dp[N][N];
    }

    public static void main(String[] args) {
        int[][] costs = {{10,20}, {30,200}, {400,50}, {30,20}};

        System.out.println(twoCitySchedCost(costs));
    }
}

/**
 * mj000
 * April 22, 2019 1:08 AM
 *
 * my explanation here, just in case other people need this:
 * for (i+j)th people, he/she can be assigned either to A city or B city,
 * the min cost if he is assigned to A city: dp[i-1][j]+costs[i+j-1][0]; //because it is to A, so we should use i-1
 * the min cost if he is assigned to B city: dp[i][j-1]+costs[i+j-1][1]; //because it is to B, so we should use j-1
 * so dp[i][j] = Math.min(dp[i-1][j]+costs[i+j-1][0] , dp[i][j-1]+costs[i+j-1][1]);
 *
 * another way to represent the dp equation is: dp[totalPerson][personToA], toatalPerson is the number of people have
 * been assigned, and personToA of them are assigned to city A, so the the equation:
 * dp[totalPerson][personToA]= Math.min(dp[totalPerson-1][personToA]+costs[totalPerson-1][1], //the last one to B
 * dp[totalPerson-1][personToA-1]+costs[totalPerson-1][0]);//the last one to A
 */