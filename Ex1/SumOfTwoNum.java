package Ex1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] { 3, 2, 4 };
        long start = System.nanoTime();
        System.out.println(Arrays.toString(solution.solve1(nums, 6)));
        long end = System.nanoTime();
        System.out.println("excution time: " + (end - start));
    }
}
    class Solution {
        public int[] solve1(int[] nums, int target) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] { i, j };
                    }
                }
            }
            return null;
        }

        public int[] solve2(int[] nums, int target) {
            int len = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[] { map.get(target - nums[i]), i };
                } else {
                    map.put(nums[i], i);
                }
            }
            return null;
        }
    }
