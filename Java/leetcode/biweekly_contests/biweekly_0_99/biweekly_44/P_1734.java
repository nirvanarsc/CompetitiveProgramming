package leetcode.biweekly_contests.biweekly_0_99.biweekly_44;

public class P_1734 {

    public int[] decode(int[] encoded) {
        final int n = encoded.length + 1;
        int t = 0;
        for (int num : encoded) {
            t ^= num;
        }
        int last = t;
        int curr = t;
        for (int i = 0; i < encoded.length - 1; i++) {
            curr ^= encoded[i];
            last ^= curr;
        }
        for (int i = 1; i <= n; i++) {
            last ^= i;
        }
        final int[] res = new int[n];
        res[n - 1] = last;
        for (int i = n - 2; i >= 0; i--) {
            res[i] = res[i + 1] ^ encoded[i];
        }
        return res;
    }
}
