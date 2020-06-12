package algorithm.Design.p381;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-12 19:53
 * @Reference https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/discuss/85555/Clean-O(1)-Java-Solution-with-HashMap-and-Set
 */
public class RandomizedCollection {

    private ArrayList<Integer> nums;
    private HashMap<Integer, LinkedHashSet<Integer>> locations;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        locations = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!locations.containsKey(val)) {
            locations.put(val, new LinkedHashSet<>());
        }
        locations.get(val).add(nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!locations.containsKey(val)) {
            return false;
        }
        LinkedHashSet<Integer> valLocs = locations.get(val);
        int indexToReplace = valLocs.iterator().next();
        int lastIndex = nums.size() - 1;
        // valLocs.remove Must be before the "if" body, otherwise when val==lastVal,
        // indexToReplace will be removed, which should not be removed.
        valLocs.remove(indexToReplace);
        if (indexToReplace != lastIndex) {
            int lastVal = nums.get(lastIndex);
            LinkedHashSet<Integer> lastLocs = locations.get(lastVal);
            nums.set(indexToReplace, lastVal);
            lastLocs.remove(lastIndex);
            lastLocs.add(indexToReplace);
        }
        // DO NOT valLocs.remove(indexToReplace); HERE AFTER "if"
        nums.remove(lastIndex);
        if (valLocs.isEmpty()) {
            locations.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */