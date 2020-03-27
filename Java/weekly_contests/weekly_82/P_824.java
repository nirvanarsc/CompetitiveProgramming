package weekly_contests.weekly_82;

public class P_824 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public String toGoatLatin(String S) {
        final String[] words = S.split(" ");
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            final String word = words[i];
            if ("aeiouAEIOU".indexOf(word.charAt(0)) == -1) {
                sb.append(word, 1, word.length());
                sb.append(word.charAt(0));
            } else {
                sb.append(word);
            }
            sb.append('m');
            sb.append("a".repeat(i + 2));
            sb.append(' ');
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
