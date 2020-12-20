package leetcode.weekly_contests.weekly_220;

import java.util.ArrayList;
import java.util.List;

public class P_1694 {

    public String reformatNumber(String number) {
        final List<Character> list = new ArrayList<>();
        for (char c : number.toCharArray()) {
            if (c != ' ' && c != '-') {
                list.add(c);
            }
        }
        int total = list.size();
        final char[] res = new char[200];
        int i = 0;
        int j = 0;
        while (total > 4) {
            res[i++] = list.get(j++);
            res[i++] = list.get(j++);
            res[i++] = list.get(j++);
            res[i++] = '-';
            total -= 3;
        }
        if (total == 2) {
            res[i++] = list.get(j++);
            res[i++] = list.get(j);
        } else if (total == 3) {
            res[i++] = list.get(j++);
            res[i++] = list.get(j++);
            res[i++] = list.get(j);
        } else {
            res[i++] = list.get(j++);
            res[i++] = list.get(j++);
            res[i++] = '-';
            res[i++] = list.get(j++);
            res[i++] = list.get(j);
        }
        return new String(res, 0, i);
    }
}
