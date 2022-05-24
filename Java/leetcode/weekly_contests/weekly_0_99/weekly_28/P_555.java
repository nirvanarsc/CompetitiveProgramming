package leetcode.weekly_contests.weekly_0_99.weekly_28;

public class P_555 {

    public String splitLoopedString(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            final String rev = new StringBuilder(strs[i]).reverse().toString();
            if (strs[i].compareTo(rev) < 0) {
                strs[i] = rev;
            }
        }
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            final String rev = new StringBuilder(strs[i]).reverse().toString();
            for (String st : new String[] { strs[i], rev }) {
                for (int k = 0; k < st.length(); k++) {
                    final StringBuilder t = new StringBuilder(st.substring(k));
                    for (int j = i + 1; j < strs.length; j++) {
                        t.append(strs[j]);
                    }
                    for (int j = 0; j < i; j++) {
                        t.append(strs[j]);
                    }
                    t.append(st, 0, k);
                    if (t.toString().compareTo(res) > 0) {
                        res = t.toString();
                    }
                }
            }
        }
        return res;
    }
}
