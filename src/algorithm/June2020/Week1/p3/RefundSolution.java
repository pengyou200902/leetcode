package algorithm.June2020.Week1.p3;

import java.util.Arrays;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-04 22:36
 * @Reference https://leetcode.com/problems/two-city-scheduling/discuss/667786/Java-or-C%2B%2B-or-Python3-or-With-detailed-explanation
 * EXPLANATION:-
 * The problem is to send n persons to city A
 * and n persons to city B with minimum cost.
 *
 * The idea is to send each person to city A.
 * costs = [[10,20],[30,200],[400,50],[30,20]]
 *
 * So, totalCost = 10 + 30 + 400 + 30 = 470
 *
 * Now, we need to send n persons to city B.
 * Which persons do we need to send city B?
 *
 * Here, we need to minimize the cost.
 * We have already paid money to go to city A.
 * So, Send the persons to city B who get more refund
 * so that our cost will be minimized.
 *
 * So, maintain refunds of each person
 * refund[i] = cost[i][1] - cost[i][0]
 *
 * So, refunds of each person
 *     refund = [10, 170, -350, -10]
 *
 * Here, refund +ve means we need to pay
 *              -ve means we will get refund.
 *
 * So, sort the refund array.
 *
 * refund = [-350, -10, 10, 170]
 *
 * Now, get refund for N persons,
 * totalCost += 470 + -350 + -10 = 110
 *
 * So, minimum cost is 110
 */
public class RefundSolution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int i = 0;
        int minCost = 0;
        int[] refund = new int[costs.length];
        for (int[] costAB: costs){
            refund[i++] = costAB[1] - costAB[0];
            minCost += costAB[0];
        }
        Arrays.sort(refund);
        for (int j = 0; j < n; j++) {
            minCost += refund[j];
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[][] costs = {{10,20}, {30,200}, {400,50}, {30,20}};

        System.out.println(new RefundSolution().twoCitySchedCost(costs));
    }

}
