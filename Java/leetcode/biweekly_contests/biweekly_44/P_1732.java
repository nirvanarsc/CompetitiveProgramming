package leetcode.biweekly_contests.biweekly_44;

public class P_1732 {

    public int largestAltitude(int[] gain) {
        final int[] res = new int[gain.length + 1];
        for (int i = 0; i < gain.length; i++) {
            res[i + 1] = res[i] + gain[i];
        }
        int max = (int) -1e5;
        for (int num : res) {
            max = Math.max(max, num);
        }
        return max;
    }
}
