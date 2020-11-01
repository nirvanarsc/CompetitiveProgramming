package leetcode.weekly_contests.weekly_213;

public class P_1641 {

    public int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int j = 2; j <= n; j++) {
            final int nA = a + e + i + o + u;
            final int nE = e + i + o + u;
            final int nI = i + o + u;
            final int nO = o + u;
            final int nU = u;
            a = nA;
            e = nE;
            i = nI;
            o = nO;
            u = nU;
        }
        return a + e + i + o + u;
    }
}
