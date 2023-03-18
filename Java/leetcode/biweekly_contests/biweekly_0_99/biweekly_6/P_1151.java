package leetcode.biweekly_contests.biweekly_0_99.biweekly_6;

public class P_1151 {

    public int minSwaps(int[] data) {
        int size = 0;
        for (int d : data) {
            size += d;
        }
        int res = data.length, j = 0, zeroes = 0;
        for (int item : data) {
            size--;
            zeroes += item == 0 ? 1 : 0;
            while (size < 0) {
                size++;
                zeroes -= data[j++] == 0 ? 1 : 0;
            }
            if (size == 0) {
                res = Math.min(res, zeroes);
            }
        }
        return res;
    }
}
