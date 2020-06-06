package medium;

public class P_223 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int curr = (Math.abs(A - C) * Math.abs(B - D)) + (Math.abs(E - G) * Math.abs(F - H));
        final int m = Math.max(A, E);
        final int n = Math.max(B, F);
        final int p = Math.min(C, G);
        final int q = Math.min(D, H);
        if (m < p && n < q) {
            curr -= (p - m) * (q - n);
        }
        return curr;
    }
}
