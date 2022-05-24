package leetcode.weekly_contests.weekly_200_299.weekly_207;

@SuppressWarnings({ "DynamicRegexReplaceableByCompiledPattern", "StringRepeatCanBeUsed" })
public class P_1592 {

    public String reorderSpaces(String text) {
        final String[] words = text.trim().split("\\s+");
        int spaces = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaces++;
            }
        }
        if (words.length == 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append(words[0]);
            for (int i = 0; i < spaces; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }
        final int normalizedSpace = spaces / (words.length - 1);
        final int extraSpace = spaces % (words.length - 1);
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            for (int j = 0; j < (i != words.length - 1 ? normalizedSpace : extraSpace); j++) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
