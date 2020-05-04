package weekly_contests.weekly_27;

public class P_557 {

    public String reverseWords(String s) {
        final String[] words = s.split(" ");
        final StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int j = word.length() - 1; j >= 0; j--) {
                sb.append(word.charAt(j));
            }
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
