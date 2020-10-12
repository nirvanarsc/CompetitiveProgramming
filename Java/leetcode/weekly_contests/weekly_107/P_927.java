package leetcode.weekly_contests.weekly_107;

public class P_927 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] threeEqualParts(int[] A) {
        final int[] res = { -1, -1 };
        int numOf1 = 0;
        for (int a : A) {
            if (a == 1) { numOf1++; }
        }
        if (numOf1 == 0) {
            return new int[] { 0, 2 };
        }
        if (numOf1 % 3 != 0) {
            return res;
        }

        final int partLength = numOf1 / 3;
        int index0 = -1, index1 = -1, index2 = -1;
        numOf1 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                numOf1++;
                if (numOf1 == partLength + 1) {
                    index1 = i;
                } else if (numOf1 == 2 * partLength + 1) {
                    index2 = i;
                } else if (numOf1 == 1) {
                    index0 = i;
                }
            }
        }

        while (index2 < A.length) {
            if (A[index2] == A[index0] && A[index2] == A[index1]) {
                index2++;
                index1++;
                index0++;
            } else {
                return res;
            }
        }

        return new int[] { index0 - 1, index1 };
    }
}
