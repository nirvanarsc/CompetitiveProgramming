package leetcode.weekly_contests.weekly_200_299.weekly_225;

public class P_1739 {

    public int minimumBoxes(int n) {
        int res = 0;
        for (int i = 1; i < 10000; i++) {
            for (int j = 1; j <= i; j++) {
                n -= j;
                res++;
                if (n <= 0) {
                    return res;
                }
            }
        }
        return -1;
    }

    // https://en.wikipedia.org/wiki/Triangular_number
    public int minimumBoxesTriangularNumbers(int n) {
        long s = 0;
        while (s * (s + 1) * (s + 2) / 6 < n) {
            s++;
        }
        s--;
        long s2 = 1;
        while (s * (s + 1) * (s + 2) / 6 + s2 * (s2 + 1) / 2 < n) {
            s2++;
        }
        return (int) (s * (s + 1) / 2 + s2);
    }
}
