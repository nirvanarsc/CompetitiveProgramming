package hard;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("StringRepeatCanBeUsed")
public class P_68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        final List<String> res = new ArrayList<>();
        int start = 0;
        for (int i = 0, currRow = 0; i < words.length; i++) {
            if (currRow + words[i].length() > maxWidth) {
                currRow--;
                res.add(formatRow(words, start, i, maxWidth - currRow));
                start = i;
                currRow = 0;
            }
            currRow += words[i].length() + 1;
        }
        final StringBuilder lastLine = new StringBuilder();
        for (int i = start; i < words.length; i++) {
            lastLine.append(words[i]);
            if (i != words.length - 1) {
                lastLine.append(' ');
            }
        }
        final int length = lastLine.length();
        for (int j = 0; j < maxWidth - length; j++) { lastLine.append(' '); }
        res.add(lastLine.toString());
        return res;
    }

    private static String formatRow(String[] words, int start, int end, int spaces) {
        final StringBuilder sb = new StringBuilder();
        if (end - start == 1) {
            sb.append(words[start]);
            for (int j = 0; j < spaces; j++) { sb.append(' '); }
            return sb.toString();
        }
        final int space = spaces / (end - start - 1);
        int remainder = spaces % (end - start - 1);
        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            if (i != end - 1) {
                for (int j = 0; j <= space; j++) { sb.append(' '); }
                if (remainder > 0) {
                    sb.append(' ');
                    remainder--;
                }
            }
        }
        return sb.toString();
    }
}
