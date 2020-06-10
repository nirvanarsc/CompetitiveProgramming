package easy;

import java.util.ArrayList;
import java.util.List;

public class P_293 {

    public List<String> generatePossibleNextMoves(String s) {
        final List<String> res = new ArrayList<>();
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                chars[i] = '-';
                chars[i + 1] = '-';
                res.add(new String(chars));
                chars[i] = '+';
                chars[i + 1] = '+';
            }
        }
        return res;
    }
}
