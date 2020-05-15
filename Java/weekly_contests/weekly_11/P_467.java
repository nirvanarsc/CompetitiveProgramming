package weekly_contests.weekly_11;

public class P_467 {

    public int findSubstringInWraproundString(String p) {
        final int[] count = new int[26];
        int maxLengthCur = 1;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                maxLengthCur++;
            } else {
                maxLengthCur = 1;
            }
            final int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }
}
