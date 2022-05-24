package leetcode.weekly_contests.weekly_0_99.weekly_9;

@SuppressWarnings("StringRepeatCanBeUsed")
public class P_423 {

    public String originalDigits(String s) {
        final int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == 'z') { count[0]++; }
            if (c == 'w') { count[2]++; }
            if (c == 'x') { count[6]++; }
            if (c == 's') { count[7]++; }
            if (c == 'g') { count[8]++; }
            if (c == 'u') { count[4]++; }
            if (c == 'f') { count[5]++; }
            if (c == 'h') { count[3]++; }
            if (c == 'i') { count[9]++; }
            if (c == 'o') { count[1]++; }
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
