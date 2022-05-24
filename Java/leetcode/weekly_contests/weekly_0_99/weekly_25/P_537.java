package leetcode.weekly_contests.weekly_0_99.weekly_25;

public class P_537 {

    public String complexNumberMultiply(String num1, String num2) {
        final int idx1 = num1.indexOf('+');
        final int idx2 = num2.indexOf('+');
        final int aR = Integer.parseInt(num1.substring(0, idx1));
        final int aI = Integer.parseInt(num1.substring(idx1 + 1, num1.length() - 1));
        final int bR = Integer.parseInt(num2.substring(0, idx2));
        final int bI = Integer.parseInt(num2.substring(idx2 + 1, num2.length() - 1));
        final int nR = aR * bR - aI * bI;
        final int nI = aR * bI + aI * bR;
        return String.format("%d+%di", nR, nI);
    }
}
