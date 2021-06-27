package leetcode.hard;

public class P_135 {

    public int candy(int[] ratings) {
        final int n = ratings.length;
        final int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                res[i + 1] = res[i] + 1;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                res[i - 1] = Math.max(res[i - 1], res[i] + 1);
            }
        }
        int sum = n;
        for (int candy : res) {
            sum += candy;
        }
        return sum;
    }
}
