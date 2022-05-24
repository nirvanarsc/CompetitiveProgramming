package leetcode.weekly_contests.weekly_100_199.weekly_108;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("DynamicRegexReplaceableByCompiledPattern")
public class P_929 {

    public int numUniqueEmails(String[] emails) {
        final Set<String> unique = new HashSet<>();
        for (String e : emails) {
            final String[] split = e.split("@");
            String localName = split[0].replaceAll("\\.", "");
            final int idx = localName.indexOf('+');
            if (idx > 0) {
                localName = localName.substring(0, idx);
            }
            unique.add(localName + '@' + split[1]);
        }
        return unique.size();
    }
}
