package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class P_151 {

    public String reverseWords(String s) {
        final List<String> list = new ArrayList<>();
        final char[] w = s.toCharArray();
        final int n = w.length;
        for (int i = 0; i < n; i++) {
            if (w[i] != ' ') {
                int j = i;
                while (j < n && w[j] != ' ') {
                    j++;
                }
                list.add(s.substring(i, j));
                i = j - 1;
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            if (i > 0) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
