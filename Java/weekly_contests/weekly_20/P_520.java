package weekly_contests.weekly_20;

public class P_520 {

    public boolean detectCapitalUse(String word) {
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
}
