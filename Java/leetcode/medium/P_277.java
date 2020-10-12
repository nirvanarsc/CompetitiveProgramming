package leetcode.medium;

public class P_277 {

    boolean knows(int a, int b) {
        return (a + b) % 2 == 0;
    }

    public int findCelebrity(int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (knows(res, i)) {
                res = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != res && (knows(res, i) || !knows(i, res))) {
                return -1;
            }
        }
        return res;
    }

    public int findCelebrityBF(int n) {
        final int[] inDeg = new int[n];
        final int[] outDeg = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    outDeg[i]++;
                    inDeg[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (outDeg[i] == 0 && inDeg[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
