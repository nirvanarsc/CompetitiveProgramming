package leetcode.weekly_contests.weekly_104;

public class P_914 {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        final int[] count = new int[(int) (1e4 + 5)];
        for (int num : deck) {
            count[num]++;
        }
        int groupSize = -1;
        for (int value : count) {
            if (value > 0) {
                if (groupSize == -1) {
                    groupSize = value;
                } else {
                    groupSize = gcd(groupSize, value);
                }
            }
        }
        return groupSize > 1;
    }
}
