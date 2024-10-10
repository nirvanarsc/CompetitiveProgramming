package leetcode.weekly_contests.weekly_400_499.weekly_417;

public class P_4 {

    public char kthCharacter(long k, int[] operations) {
        final int n = Math.min(operations.length, 60);
        int add = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k > 1L << i) {
                add = (add + operations[i]) % 26;
                k ^= 1L << i;
            }
        }
        return (char) ('a' + add);
    }
}
