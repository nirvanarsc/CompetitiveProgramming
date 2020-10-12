package leetcode.weekly_contests.weekly_40;

public class P_640 {

    public String solveEquation(String equation) {
        final String[] parts = equation.split("=");
        final int[] leftVals = evaluate(parts[0]);
        final int[] rightVals = evaluate(parts[1]);
        final int cntX = leftVals[0] - rightVals[0];
        final int cntNum = leftVals[1] - rightVals[1];
        if (cntX == 0) {
            return cntNum != 0 ? "No solution" : "Infinite solutions";
        }
        return "x=" + -cntNum / cntX;
    }

    @SuppressWarnings("DynamicRegexReplaceableByCompiledPattern")
    private static int[] evaluate(String exp) {
        final int[] result = new int[2];
        final String[] expElements = exp.split("(?=[-+])");
        for (String ele : expElements) {
            if ("+x".equals(ele) || "x".equals(ele)) {
                result[0]++;
            } else if ("-x".equals(ele)) {
                result[0]--;
            } else if (ele.contains("x")) {
                result[0] += Integer.valueOf(ele.substring(0, ele.indexOf('x')));
            } else {
                result[1] += Integer.valueOf(ele);
            }
        }
        return result;
    }
}
