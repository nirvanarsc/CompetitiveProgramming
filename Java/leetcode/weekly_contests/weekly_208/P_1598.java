package leetcode.weekly_contests.weekly_208;

public class P_1598 {

    public int minOperations(String[] logs) {
        int level = 0;
        for (String log : logs) {
            if (log.charAt(0) == '.' && log.charAt(1) == '.') {
                level = Math.max(0, level - 1);
            } else if (log.charAt(0) != '.') {
                level++;
            }
        }
        return level;
    }
}
