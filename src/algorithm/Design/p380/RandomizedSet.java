package algorithm.Design.p380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 * @Author Friende.Peng_You
 * @Date 2020-06-12 15:18
 * @Reference https://leetcode.com/problems/insert-delete-getrandom-o1/discuss/85401/Java-solution-using-a-HashMap-and-an-ArrayList-along-with-a-follow-up.-(131-ms)
 */
class RandomizedSet {
    private ArrayList<Integer> nums;
    private HashMap<Integer, Integer> locations;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locations = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locations.containsKey(val)) return false;
        nums.add(val);
        locations.put(val, nums.size() - 1);
        System.out.println("After insert---------------------------------------------");
        System.out.println(nums.toString());
        System.out.println(locations.toString());
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locations.containsKey(val)) return false;
        int index = locations.get(val);
        if (index < nums.size() - 1) {
            // 若要删的不是最后一个，那么就把最后一个值换到这里，减少移动操作
            // not the last one then swap the last one with this val
            int lastOne = nums.get(nums.size() - 1);
            nums.set(index, lastOne);
            locations.put(lastOne, index);
        }
        locations.remove(val);
        nums.remove(nums.size() - 1);
        System.out.println("After remove---------------------------------------------");
        System.out.println(nums.toString());
        System.out.println(locations.toString());
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        // 注意随机数的范围
        return nums.get(random.nextInt(nums.size()));
    }

    public static void main(String[] args) {
//        HashMap<Integer, Boolean> map = new HashMap<>();
//        map.put(1,true);
//        map.put(1,false);
//        System.out.println(map.toString());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
