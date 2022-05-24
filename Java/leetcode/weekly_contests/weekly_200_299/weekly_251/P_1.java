package leetcode.weekly_contests.weekly_200_299.weekly_251;

public class P_1 {

    public int getLucky(String s, int k) {
        int prev = -1;
        for (int i = 0; i < k; i++) {
            int curr = 0;
            if (prev == -1) {
                for (char c : s.toCharArray()) {
                    int z = c - 'a' + 1;
                    while (z > 0) {
                        curr += z % 10;
                        z /= 10;
                    }
                }
            } else {
                while (prev > 0) {
                    curr += prev % 10;
                    prev /= 10;
                }
            }
            prev = curr;
        }
        return prev;
    }
}
