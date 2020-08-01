package weekly_contests.weekly_20;

public class P_520 {

    public boolean detectCapitalUseLibrary(String word) {
        if ('A' <= word.charAt(0) && word.charAt(0) <= 'Z') {
            if (word.equals(word.toUpperCase())) {
                return true;
            }
            final String sub = word.substring(1);
            if (sub.equals(sub.toLowerCase())) {
                return true;
            }
        }
        return word.equals(word.toLowerCase());
    }

    public boolean detectCapitalUse(String word) {
        int prevCapital = -1;
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                if (prevCapital + 1 == i) {
                    prevCapital++;
                } else {
                    return false;
                }
            }
        }
        return prevCapital == -1 || prevCapital == word.length() - 1 || prevCapital == 0;
    }
}
