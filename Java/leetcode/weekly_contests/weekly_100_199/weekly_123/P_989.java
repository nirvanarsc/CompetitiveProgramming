package leetcode.weekly_contests.weekly_100_199.weekly_123;

import java.util.LinkedList;
import java.util.List;

public class P_989 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public List<Integer> addToArrayForm(int[] A, int K) {
        final LinkedList<Integer> ans = new LinkedList<>();
        for (int i = A.length - 1; K > 0 || i >= 0; i--, K /= 10) {
            if (i >= 0) { K += A[i]; }
            ans.offerFirst(K % 10);
        }
        return ans;
    }
}

