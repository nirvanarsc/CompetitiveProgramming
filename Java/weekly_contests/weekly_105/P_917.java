package weekly_contests.weekly_105;

public class P_917 {

    public String reverseOnlyLetters(String s) {
        final char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            final boolean start = Character.isLetter(chars[i]);
            final boolean end = Character.isLetter(chars[j]);
            if (end && start) {
                final char temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;
                i++;
                j--;
            }
            if (!end) { j--; }
            if (!start) { i++; }
        }
        return new String(chars);
    }
}
