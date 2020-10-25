package leetcode.weekly_contests.weekly_212;

public class P_1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int prev = 0;
        int max = -1;
        char res = '#';
        for (int i = 0; i < releaseTimes.length; i++) {
            final int curr = releaseTimes[i] - prev;
            if (curr > max) {
                max = curr;
                res = keysPressed.charAt(i);
            } else if (curr == max && res < keysPressed.charAt(i)) {
                res = keysPressed.charAt(i);
            }
            prev = releaseTimes[i];
        }
        return res;
    }
}
