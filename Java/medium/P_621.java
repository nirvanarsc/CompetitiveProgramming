package medium;

import java.util.Arrays;

public class P_621 {

    public int leastIntervalSort(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        final int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);

        int i = 25;
        while (i >= 0 && map[i] == map[25]) {
            i--;
        }

        return Math.max((map[25] - 1) * (n + 1) + 25 - i, tasks.length);
    }

    public int leastInterval(char[] tasks, int n) {
        final int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        final int partCount = max - 1;
        final int partLength = n - (maxCount - 1);
        final int emptySlots = partCount * partLength;
        final int availableTasks = tasks.length - max * maxCount;
        final int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}
