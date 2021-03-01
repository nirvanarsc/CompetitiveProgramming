package leetcode.weekly_contests.weekly_31;

public class P_575 {

    public int distributeCandies(int[] candyType) {
        final boolean[] seen = new boolean[(int) (2e5 + 5)];
        int uniq = 0;
        for (int c : candyType) {
            if (!seen[(int) (c + 1e5)]) {
                uniq++;
                seen[(int) (c + 1e5)] = true;
            }
        }
        return Math.min(uniq, candyType.length / 2);
    }
}
