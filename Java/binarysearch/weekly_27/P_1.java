package binarysearch.weekly_27;

public class P_1 {

    public int solve(int[] a, int[] b) {
        int[] l = new int[7];
        int[] r = new int[7];
        int s1 = 0;
        int s2 = 0;
        for (int num : a) {
            l[num]++;
            s1 += num;
        }
        for (int num : b) {
            r[num]++;
            s2 += num;
        }
        if (s1 < s2) {
            final int[] temp = l;
            l = r;
            r = temp;
            final int tempS = s1;
            s1 = s2;
            s2 = tempS;
        }
        int res = 0;
        int i = 6;
        int j = 1;
        while (s1 > s2 && (i > 1 || j < 6)) {
            while (l[i] == 0 && i > 1) {
                i--;
            }
            while (r[j] == 0 && j < 6) {
                j++;
            }
            res++;
            final int choice1 = i - 1;
            final int choice2 = 6 - j;
            if (choice1 >= choice2) {
                l[i]--;
                s1 -= i - 1;
            } else {
                r[j]--;
                s2 += 6 - j;
            }
        }
        return s1 <= s2 ? res : -1;
    }
}
