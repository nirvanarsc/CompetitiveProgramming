package weekly_contests.weekly_108;

import java.util.HashSet;
import java.util.Set;

public class P_929 {

    @SuppressWarnings("DynamicRegexReplaceableByCompiledPattern")
    public int numUniqueEmails(String[] emails) {
        final Set<String> unique = new HashSet<>();
        for (String e : emails) {
            final String[] split = e.split("@");
            String localName = split[0].replaceAll("\\.", "");
            final String domain = split[1];
            if (localName.indexOf('+') > 0) {
                localName = localName.substring(0, localName.indexOf('+'));
            }
            unique.add(localName + '@' + domain);
        }
        return unique.size();
    }
}
