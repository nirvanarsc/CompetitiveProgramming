package leetcode.weekly_contests.weekly_200_299.weekly_230;

import java.util.List;

public class P_1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        for (List<String> item : items) {
            final String t = item.get(0);
            final String c = item.get(1);
            final String n = item.get(2);
            if ("type".equals(ruleKey) && t.equals(ruleValue)) {
                res++;
            } else if ("color".equals(ruleKey) && c.equals(ruleValue)) {
                res++;
            } else if ("name".equals(ruleKey) && n.equals(ruleValue)) {
                res++;
            }
        }
        return res;
    }
}
