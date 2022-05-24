package leetcode.weekly_contests.weekly_0_99.weekly_37;

public class P_621 {

    public int leastInterval(char[] tasks, int n) {
        final int[] map = new int[26];
        int max = 0, count = 0;
        for (char c : tasks) {
            max = Math.max(max, ++map[c - 'A']);
        }
        for (int freq : map) {
            count += freq == max ? 1 : 0;
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + count);
    }
}
