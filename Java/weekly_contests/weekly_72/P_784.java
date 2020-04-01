package weekly_contests.weekly_72;

import java.util.ArrayList;
import java.util.List;

public class P_784 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public List<String> letterCasePermutation(String S) {
        final List<String> res = new ArrayList<>();
        helper(S.toCharArray(), 0, res);
        return res;
    }

    public void helper(char[] chars, int pos, List<String> res) {
        if (pos == chars.length) {
            res.add(new String(chars));
            return;
        }
        if (Character.isLetter(chars[pos])) {
            chars[pos] = Character.toLowerCase(chars[pos]);
            helper(chars, pos + 1, res);
            chars[pos] = Character.toUpperCase(chars[pos]);
        }
        helper(chars, pos + 1, res);
    }
}
