package leetcode.weekly_contests.weekly_200_299.weekly_200;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1535 {

    static class Pair {
        int num;
        int wins;

        Pair(int num, int wins) {
            this.num = num;
            this.wins = wins;
        }
    }

    public int getWinnerDQ(int[] arr, int k) {
        final Deque<Pair> dq = new ArrayDeque<>();
        for (int value : arr) {
            dq.offerLast(new Pair(value, 0));
        }
        k = Math.min(arr.length - 1, k);
        while (true) {
            final Pair left = dq.removeFirst();
            final Pair right = dq.removeFirst();
            if (left.wins == k) {
                return left.num;
            }
            if (left.num > right.num) {
                left.wins++;
                dq.addFirst(left);
                dq.addLast(right);
            } else {
                right.wins++;
                dq.addFirst(right);
                dq.addLast(left);
            }
        }
    }

    public int getWinner(int[] arr, int k) {
        int wins = 0, curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > curr) {
                wins = 0;
                curr = arr[i];
            }
            if (++wins == k) {
                break;
            }
        }
        return curr;
    }
}
