package hard;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class P_330 {

    public int minPatches(int[] nums, int n) {
        List<Integer> curr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int res = 0;
        TreeSet<Integer> ts = subsetsWithDup(nums);
        loop:
        while (true) {
            for (int i = 1; i <= n; i++) {
                if (!ts.contains(i)) {
                    res++;
                    curr.add(i);
                    ts = subsetsWithDup(curr.stream().mapToInt(Integer::intValue).toArray());
                    continue loop;
                }
            }
            break;
        }
        return res;
    }

    public static TreeSet<Integer> subsetsWithDup(int[] nums) {
        final TreeSet<Integer> res = new TreeSet<>();
        Arrays.sort(nums);
        recurse1(res, 0, nums, 0);
        return res;
    }

    private static void recurse1(TreeSet<Integer> res, int curr, int[] nums, int start) {
        if (curr > 0) {
            res.add(curr);
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) { continue; }
            curr += nums[i];
            recurse1(res, curr, nums, i + 1);
            curr -= nums[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] { 1, 2, 4, 5, 10 }));
    }

}
