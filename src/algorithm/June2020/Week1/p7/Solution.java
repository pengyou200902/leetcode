package algorithm.June2020.Week1.p7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-06 22:58
 * @Reference https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC%2B%2BJava-Solution
 *
 * 1. Pick out tallest group of people and sort them in a subarray (S). Since there's no other groups of people taller than
 * them, therefore each guy's index will be just as same as his k value.
 * 2. For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
//        Arrays.sort(people, new Comparator<int[]>(){
//            @Override
//            public int compare(int[] o1, int[] o2){
//                return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
//            }
//        });
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

//        see(people);

        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void see(int[][] arr) {
        for (int[] x :
                arr) {
            System.out.printf("%s, ", Arrays.toString(x));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Solution.see(new Solution().reconstructQueue(people));
    }
}
