package leetcode.medium;

import java.util.Arrays;

public class P_451 {

    public String frequencySort(String s) {
        final int n = s.length();
        final int alphabetSize = 128;
        final int[] f = new int[alphabetSize];
        final int[][] sorted = new int[alphabetSize][2];
        final char[] res = new char[n];
        for (char c : s.toCharArray()) {
            f[c]++;
        }
        for (int i = 0; i < alphabetSize; i++) {
            sorted[i] = new int[] { f[i], i };
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(b[0], a[0]));
        int idx = 0;
        for (int i = 0; i < alphabetSize; i++) {
            final char c = (char) sorted[i][1];
            for (int j = 0; j < sorted[i][0]; j++) {
                res[idx++] = c;
            }
        }
        return new String(res);
    }
}
