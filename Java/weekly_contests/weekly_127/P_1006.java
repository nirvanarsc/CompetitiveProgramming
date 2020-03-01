package weekly_contests.weekly_127;

public class P_1006 {

    public int clumsy(int N) {
        if (N == 1) { return 1; }
        if (N == 2) { return 2; }
        if (N == 3) { return 6; }
        if (N == 4) { return 7; }
        if (N % 4 == 1) { return N + 2; }
        if (N % 4 == 2) { return N + 2; }
        if (N % 4 == 3) { return N - 1; }
        return N + 1;
    }

    public int clumsyBF(int N) {
        if (N == 0) { return 0; }
        if (N == 1) { return 1; }
        if (N == 2) { return 2; }
        if (N == 3) { return 6; }
        return N * (N - 1) / (N - 2) + helper(N - 3);
    }

    public int helper(int N) {
        if (N == 0) { return 0; }
        if (N == 1) { return 1; }
        if (N == 2) { return 1; }
        if (N == 3) { return 1; }
        return N - (N - 1) * (N - 2) / (N - 3) + helper(N - 4);
    }
}
