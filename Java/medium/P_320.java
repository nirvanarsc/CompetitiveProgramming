package medium;

import java.util.ArrayList;
import java.util.List;

public class P_320 {

    public List<String> generateAbbreviations(String word) {
        final List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), word.toCharArray(), 0, 0);
        return res;
    }

    private static void dfs(List<String> res, StringBuilder curr, char[] wordArray, int pos, int numCount) {
        if (pos == wordArray.length) {
            res.add(curr.append(numCount == 0 ? "" : numCount).toString());
            return;
        }
        final int len = curr.length();
        dfs(res, curr, wordArray, pos + 1, numCount + 1);
        curr.setLength(len);

        curr.append(numCount == 0 ? "" : numCount).append(wordArray[pos]);
        dfs(res, curr, wordArray, pos + 1, 0);
    }
}
