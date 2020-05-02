package weekly_contests.weekly_28;

public class P_551 {

    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        int maxLate = 0;
        for (char c : s.toCharArray()) {
            absent += c == 'A' ? 1 : 0;
            if (c == 'L') {
                maxLate = Math.max(maxLate, ++late);
            } else {
                late = 0;
            }
        }
        return absent <= 1 && maxLate <= 2;
    }
}
