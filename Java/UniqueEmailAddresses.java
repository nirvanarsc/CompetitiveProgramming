import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(String[] args) {
        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };
        System.out.println(numUniqueEmails(emails));
    }

    private static int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        for (String email : emails) {
            parseEmail(email, unique);
        }

        return unique.size();

    }

    private static void parseEmail(String email, Set<String> set) {
        String[] strings = email.split("@");
        if (strings.length > 2 || strings[0].length() == 0 || strings[1].length() == 0) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : strings[0].toCharArray()) {
            if (c == '.') {
                continue;
            }
            if (c == '+') {
                break;
            }
            sb.append(c);
        }
        sb.append("@");
        sb.append(strings[1]);
        set.add(sb.toString());
    }
}
