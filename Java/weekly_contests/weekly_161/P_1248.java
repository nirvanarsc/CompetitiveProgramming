package weekly_contests.weekly_161;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P_1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        final Deque<Integer> oddIdx = new ArrayDeque<>();
        int res = 0, prevIdx = -1, i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                if (oddIdx.size() == k) {
                    res += (oddIdx.getFirst() - prevIdx) * (i - oddIdx.getLast());
                    prevIdx = oddIdx.removeFirst();
                }
                oddIdx.addLast(i);
            }
        }
        if (oddIdx.size() == k) {
            res += (oddIdx.getFirst() - prevIdx) * (i - oddIdx.getLast());
        }
        return res;
    }

    public int numberOfSubarrays560(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num % 2 == 0 ? 0 : 1;
            res += map.getOrDefault(sum - k, 0);
            map.merge(sum, 1, Integer::sum);
        }
        return res;
    }

    public int numberOfSubarrays992(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        int res = 0, i = 0;
        final int n = nums.length;
        for (int j = 0; j < n; j++) {
            k -= nums[j] % 2;
            while (k < 0) {
                k += nums[i++] % 2;
            }
            res += j - i + 1;
        }
        return res;
    }
}
