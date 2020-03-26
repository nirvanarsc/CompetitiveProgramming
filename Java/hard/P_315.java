package hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import utils.DataStructures.BIT;

public class P_315 {

    // Segment Tree
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) { return Collections.emptyList(); }

        final int n = nums.length;
        final int[][] segmentTree = new int[2 * n][];
        final List<Integer> res = new LinkedList<>();

        for (int i = 0, j = n; i < n; i++, j++) {
            segmentTree[j] = new int[] { nums[i] };
        }
        for (int i = n - 1; i > 0; i--) {
            segmentTree[i] = merge(segmentTree[i * 2], segmentTree[i * 2 + 1]);
        }
        for (int i = n - 1; i >= 0; i--) {
            res.add(0, count(segmentTree, i + 1, n - 1, nums[i], n));
        }

        return res;
    }

    private static int count(int[][] seg, int left, int right, int elem, int n) {
        left += n;
        right += n;

        int sum = 0;
        while (left <= right) {
            if ((left & 1) == 1) {
                sum += countLess(seg[left], elem);
                left++;
            }
            if ((right & 1) == 0) {
                sum += countLess(seg[right], elem);
                right--;
            }
            left >>= 1;
            right >>= 1;
        }

        return sum;
    }

    private static int countLess(int[] a, int elem) {
        int l = 0, r = a.length;

        while (l < r) {
            final int mid = l + r >>> 1;
            if (a[mid] >= elem) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private static int[] merge(int[] a1, int[] a2) {
        final int[] res = new int[a1.length + a2.length];

        int i, j, k = 0;
        for (i = 0, j = 0; i < a1.length && j < a2.length; ) {
            if (a1[i] < a2[j]) { res[k++] = a1[i++]; } else { res[k++] = a2[j++]; }
        }

        while (i < a1.length) { res[k++] = a1[i++]; }
        while (j < a2.length) { res[k++] = a2[j++]; }

        return res;
    }

    // Binary Indexed Tree
    public List<Integer> countSmallerBIT(int[] nums) {
        final int[] tmp = nums.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
        }
        final BIT bit = new BIT(nums.length);
        final Integer[] ans = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = bit.query(nums[i] - 1);
            bit.add(nums[i], 1);
        }
        return Arrays.asList(ans);
    }
}
