package weekly_contests.weekly_37;

public class P_621 {

    public int leastInterval(char[] tasks, int n) {
        final int[] map = new int[26];
        int max = 0, count = 0;
        for (char task : tasks) {
            map[task - 'A']++;
            if (max == map[task - 'A']) {
                count++;
            } else if (max < map[task - 'A']) {
                max = map[task - 'A'];
                count = 1;
            }
        }
        return Math.max((max - 1) * (n + 1) + count, tasks.length);
    }
}
