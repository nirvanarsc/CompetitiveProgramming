package leetcode.weekly_contests.weekly_127;

public class P_1007 {

    public int minDominoRotations(int[] A, int[] B) {
        for (int i = 0, a = 0, b = 0; i < A.length && (A[i] == A[0] || B[i] == A[0]); i++) {
            if (A[i] != A[0]) {a++;}
            if (B[i] != A[0]) {b++;}
            if (i == A.length - 1) { return Math.min(a, b); }
        }
        for (int i = 0, a = 0, b = 0; i < A.length && (A[i] == B[0] || B[i] == B[0]); i++) {
            if (A[i] != B[0]) {a++;}
            if (B[i] != B[0]) {b++;}
            if (i == A.length - 1) { return Math.min(a, b); }
        }
        return -1;
    }
}
