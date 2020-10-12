package leetcode.weekly_contests.weekly_25;

public class P_537 {

    public String complexNumberMultiply(String a, String b) {
        final int aR = Integer.parseInt(a.substring(0, a.indexOf('+')));
        final int aI = Integer.parseInt(a.substring(a.indexOf('+') + 1, a.length() - 1));
        final int bR = Integer.parseInt(b.substring(0, b.indexOf('+')));
        final int bI = Integer.parseInt(b.substring(b.indexOf('+') + 1, b.length() - 1));
        final int nR = aR * bR - aI * bI;
        final int nI = aR * bI + aI * bR;
        return nR + "+" + nI + 'i';
    }
}
