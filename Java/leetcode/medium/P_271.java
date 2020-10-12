package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class P_271 {

    static class Codec {

        public String encode(List<String> strs) {
            final StringBuilder sb = new StringBuilder();
            for (String w : strs) {
                sb.append(w.length());
                sb.append('#');
                sb.append(w);
            }
            return sb.toString();
        }

        public List<String> decode(String s) {
            final List<String> res = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                final int j = i;
                while (s.charAt(i) != '#') {
                    i++;
                }
                final int len = Integer.parseInt(s.substring(j, i));
                i++;
                res.add(s.substring(i, i + len));
                i += len;
            }
            return res;
        }
    }
}
