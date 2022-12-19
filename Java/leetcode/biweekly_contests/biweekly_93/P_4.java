package leetcode.biweekly_contests.biweekly_93;

public class P_4 {

    public long minimumTotalCost(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        final int[] f = new int[(int) (1e5 + 5)];
        int maxFreq = 0;
        int maxFreqVal = 0;
        int swaps = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                f[nums1[i]]++;
                if (f[nums1[i]] > maxFreq) {
                    maxFreq = f[nums1[i]];
                    maxFreqVal = nums1[i];
                }
                swaps++;
                res += i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (maxFreq > swaps / 2
                && nums1[i] != nums2[i]
                && nums1[i] != maxFreqVal
                && nums2[i] != maxFreqVal) {
                swaps++;
                res += i;
            }
        }
        return maxFreq > swaps / 2 ? -1 : res;
    }
}
