package Leetcode;
import java.util.*;

public class L90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), ans);
        Set<List<Integer>> set = new HashSet<>(ans);
        return new ArrayList<>(set);
    }

    public static void generateSubsets(int[] nums, int i, List<Integer> curr, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        generateSubsets(nums, i + 1, curr, ans); //pick
        curr.remove(curr.size() - 1); //removing for backtracking
        generateSubsets(nums, i + 1, curr, ans); //notpick
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
//        Arrays.sort(nums);
        System.out.println(subsetsWithDup(nums));
    }
}
