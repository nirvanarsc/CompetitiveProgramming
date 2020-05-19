package weekly_contests.weekly_8;

public class P_418 {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        final String s = String.join(" ", sentence) + ' ';
        final int l = s.length();
        int start = 0;
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % l) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();
    }
}
