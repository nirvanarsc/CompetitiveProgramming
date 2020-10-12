package leetcode.weekly_contests.weekly_185;

public class P_1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {
        final String target = "croak";
        final int[] count = new int[5];
        int overlap = 0, res = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            final int index = target.indexOf(c);
            if (index == -1 || (index > 0 && count[index - 1] == 0)) {
                return -1;
            }
            if (index > 0) {
                count[index - 1]--;
            }
            count[index]++;
            overlap = index == 0 ? overlap + 1 : index == 4 ? overlap - 1 : overlap;
            res = Math.max(res, overlap);
        }
        return count[0] + count[1] + count[2] + count[3] > 0 ? -1 : res;
    }
}
