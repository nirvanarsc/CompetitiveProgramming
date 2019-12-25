package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import utils.NthElement;

public class P_169 {

    // HashMap -> O(n) time O(n) space
    public int majorityElement1(int[] nums) {
        final Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
            if (count.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    // Randomization -> O(n) time O(1) space
    public int majorityElement2(int[] nums) {
        final Random r = new Random();
        while (true) {
            final int idx = r.nextInt(nums.length);
            final int majority = nums[idx];
            int count = 0;
            for (int num : nums) {
                if (num == majority && ++count > nums.length / 2) {
                    return num;
                }
            }
        }
    }

    // Bit Vote -> O(32*n) time O(1) space
    public int majorityElement3(int[] nums) {
        int res = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            int count = 0;
            for (int num : nums) {
                final int mask = 1 << i;
                if ((num & mask) != 0) {
                    count++;
                }
                if (count > nums.length / 2) {
                    res |= mask;
                }
            }
        }
        return res;
    }

    // Boyer-Moore vote -> O(n) time O(1) space
    public int majorityElement4(int[] nums) {
        int counter = 0, majority = 0;
        for (int num : nums) {
            if (counter == 0) {
                majority = num;
                counter = 1;
            } else if (majority == num) {
                counter++;
            } else {
                counter--;
            }
        }
        return majority;
    }

    // Sort -> O(n log n) time O(1) space
    public int majorityElement5(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Partial Sort -> O(n) average // O(n^2) worst time O(1) space
    public int majorityElement6(int[] nums) {
        return NthElement.findKthLargest(nums, nums.length / 2 + 1);
    }

    // Divide and Conquer -> O(n log n) time O(log n) space (call stack)
    public int majorityElement7(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private static int majorityElement(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        final int mid = left + right >>> 1;
        final int ml = majorityElement(nums, left, mid);
        final int mr = majorityElement(nums, mid + 1, right);
        if (ml == mr) {
            return ml;
        }
        int c1 = 0, c2 = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == ml) {
                c1++;
            }
            if (nums[i] == mr) {
                c2++;
            }
        }

        return c1 > c2 ? ml : mr;
    }
}
