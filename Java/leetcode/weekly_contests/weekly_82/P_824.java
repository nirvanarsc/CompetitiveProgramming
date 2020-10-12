package leetcode.weekly_contests.weekly_82;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_824 {

    public String toGoatLatin(String S) {
        final String[] words = S.split(" ");
        final String vowels = "aeiouAEIOU";
        final StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            final String word = words[i];
            if (vowels.indexOf(word.charAt(0)) == -1) {
                res.append(word, 1, word.length());
                res.append(word.charAt(0));
            } else {
                res.append(word);
            }
            res.append("ma");
            res.append("a".repeat(i + 1));
            res.append(' ');
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }
}
