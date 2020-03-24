package weekly_contests.weekly_86;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
