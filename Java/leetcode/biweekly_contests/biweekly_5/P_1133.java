package leetcode.biweekly_contests.biweekly_5;

public class P_1133 {

    public int largestUniqueNumber(int[] A) {
        final int[] map = new int[1001];
        for (int num : A) {
            map[num]++;
        }
        for (int i = 1000; i >= 0; i--) {
            if (map[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
