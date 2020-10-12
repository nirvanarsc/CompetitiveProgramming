package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) { continue; }
            list.add(nums[i]);
            used[i] = true;
            dfs(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permuteUniqueSet(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        final List<Integer> curr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(0, curr, res);
        return res;
    }

    private static void dfs(int i, List<Integer> curr, List<List<Integer>> res) {
        if (i == curr.size()) {
            res.add(new ArrayList<>(curr));
        }
        final Set<Integer> seen = new HashSet<>();
        for (int k = i; k < curr.size(); k++) {
            if (seen.add(curr.get(k))) {
                Collections.swap(curr, i, k);
                dfs(i + 1, curr, res);
                Collections.swap(curr, i, k);
            }
        }
    }

    public List<List<Integer>> permuteUniqueNP(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        final List<List<Integer>> result = new ArrayList<>();
        while (!list.isEmpty()) {
            result.add(new ArrayList<>(list));
            list = nextPermutation(list);
        }
        return result;
    }

    public static List<Integer> nextPermutation(List<Integer> perm) {
        int swapIdx = -1;
        final int n = perm.size();
        for (int i = n - 1; i >= 1; i--) {
            if (perm.get(i - 1) < perm.get(i)) {
                swapIdx = i - 1;
                break;
            }
        }
        if (swapIdx == -1) {
            return Collections.emptyList();
        }
        for (int i = n - 1; i >= 1; i--) {
            if (perm.get(i) > perm.get(swapIdx)) {
                Collections.swap(perm, swapIdx, i);
                break;
            }
        }
        Collections.reverse(perm.subList(swapIdx + 1, perm.size()));
        return perm;
    }
}
