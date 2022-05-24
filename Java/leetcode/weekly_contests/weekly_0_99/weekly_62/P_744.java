package leetcode.weekly_contests.weekly_0_99.weekly_62;

public class P_744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (letters[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return letters[lo % letters.length];
    }
}
