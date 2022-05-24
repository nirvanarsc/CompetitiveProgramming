package leetcode.weekly_contests.weekly_0_99.weekly_9;

import java.util.List;

public class P_422 {

    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            int j = i;
            while (j < Math.max(words.size(), words.get(i).length())) {
                final char left = (j >= words.size() || i >= words.get(j).length()) ? '*'
                                                                                    : words.get(j).charAt(i);
                final char right = j >= words.get(i).length() ? '*' : words.get(i).charAt(j);
                if (left != right) {
                    return false;
                }
                j++;
            }
        }
        return true;
    }
}
