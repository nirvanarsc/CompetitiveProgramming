package leetcode.biweekly_contests.biweekly_100_199.biweekly_118;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public List<Integer> findWordsContaining(String[] words, char x) {
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                res.add(i);
            }
        }
        return res;
    }
}
