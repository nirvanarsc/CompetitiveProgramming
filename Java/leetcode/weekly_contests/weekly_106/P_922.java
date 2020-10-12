package leetcode.weekly_contests.weekly_106;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_922 {

    public int[] sortArrayByParityII(int[] A) {
        final int[] map = new int[1001];
        for (int num : A) { map[num]++; }
        int even = 0;
        int odd = 1;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                while (even % 2 != 0 || map[even] == 0) { even++; }
                A[i] = even;
                map[even]--;
            } else {
                while (odd % 2 == 0 || map[odd] == 0) { odd++; }
                A[i] = odd;
                map[odd]--;
            }
        }
        return A;
    }

    public int[] sortArrayByParity(int[] A) {
        int odd = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 != 0) {
                while (A[odd] % 2 != 0) {
                    odd += 2;
                }
                final int tmp = A[i];
                A[i] = A[odd];
                A[odd] = tmp;
            }
        }
        return A;
    }
}
