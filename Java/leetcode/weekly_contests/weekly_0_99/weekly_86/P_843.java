package leetcode.weekly_contests.weekly_0_99.weekly_86;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_843 {

    @FunctionalInterface
    interface Master {
        int guess(String word);
    }

    public void findSecretWord(String[] wordlist, Master master) {
        List<Integer> valid = new ArrayList<>();
        for (int i = 0; i < wordlist.length; i++) {
            valid.add(i);
        }
        while (true) {
            Collections.shuffle(valid);
            final int guess = valid.remove(valid.size() - 1);
            final int match = master.guess(wordlist[guess]);
            if (match == 6) {
                return;
            }
            final List<Integer> next = new ArrayList<>();
            for (int out : valid) {
                if (countMatch(wordlist[out], wordlist[guess]) == match) {
                    next.add(out);
                }
            }
            valid = next;
        }
    }

    public void findSecretWordMM(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            final Map<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist) {
                for (String w2 : wordlist) {
                    if (countMatch(w1, w2) == 0) {
                        count.merge(w1, 1, Integer::sum);
                    }
                }
            }
            String guess = "";
            int min = 100;
            for (String w : wordlist) {
                if (count.getOrDefault(w, 0) < min) {
                    min = count.getOrDefault(w, 0);
                    guess = w;
                }
            }
            x = master.guess(guess);
            final List<String> next = new ArrayList<>();
            for (String w : wordlist) {
                if (countMatch(guess, w) == x) {
                    next.add(w);
                }
            }
            wordlist = next.toArray(String[]::new);
        }
    }

    public int countMatch(String a, String b) {
        int match = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                match++;
            }
        }
        return match;
    }
}
