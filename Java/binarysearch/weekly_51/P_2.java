package binarysearch.weekly_51;

public class P_2 {

    public int solve(String s, String t) {
        final int[] f = new int[26];
        final int[] idx = new int[26];
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }
        final int[][] map = new int[26][];
        for (int i = 0; i < 26; i++) {
            map[i] = new int[f[i]];
        }
        for (int i = 0; i < s.length(); i++) {
            final int p = s.charAt(i) - 'a';
            map[p][idx[p]++] = i;
        }
        int curr = 0;
        int res = 1;
        for (int i = 0; i < t.length(); i++) {
            final int[] letter = map[t.charAt(i) - 'a'];
            int next = lowerBound(letter, curr);
            if (next == letter.length) {
                res++;
                curr = 0;
                next = lowerBound(letter, curr);
                if (next == letter.length) {
                    return -1;
                }
            }
            curr = letter[next] + 1;
        }
        return res;
    }

    private static int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
