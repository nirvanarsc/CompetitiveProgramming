package biweekly_contests.biweekly_26;

public class P_1446 {

    public int maxPower(String s) {
        final int len = s.length();
        final int[] count = new int[26];
        int j = 0, maxCount = 0, maxLength = 0;
        for (int i = 0; i < len; i++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(i) - 'a']);
            while (i - j + 1 - maxCount > 0) {
                count[s.charAt(j) - 'a']--;
                j++;
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }
}
