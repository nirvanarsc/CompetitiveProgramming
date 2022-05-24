package leetcode.weekly_contests.weekly_100_199.weekly_174;

import java.util.Arrays;

public class P_1338 {

    public int minSetSize(int[] arr) {
        final int n = arr.length;
        final int[] freq = new int[(int) (1e5 + 5)];
        for (int num : arr) {
            freq[num]++;
        }
        Arrays.sort(freq);
        int curr = 0;
        int idx = freq.length - 1;
        while (curr < n / 2) {
            curr += freq[idx--];
        }
        return freq.length - idx - 1;
    }
}
