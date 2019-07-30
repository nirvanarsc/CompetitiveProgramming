import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SubdomainVisitCount {

    public static void main(String[] args) {
        final String[] cpdomains1 = { "9001 discuss.leetcode.com" };
        final String[] cpdomains2 = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
        for (String i : subdomainVisits(cpdomains1)) {
            System.out.println(i);
        }
        for (String i : subdomainVisits(cpdomains2)) {
            System.out.println(i);
        }
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        final Map<String, Integer> cache = new HashMap<>();
        for (String s : cpdomains) {
            final int i = s.indexOf(' ');
            final Integer visits = Integer.valueOf(s.substring(0, i));
            String domain = s.substring(i + 1);
            cache.computeIfPresent(domain, (k, v) -> v += visits);
            cache.putIfAbsent(domain, visits);
            while (domain.indexOf('.') != -1) {
                domain = domain.substring(domain.indexOf('.') + 1);
                cache.computeIfPresent(domain, (k, v) -> v += visits);
                cache.putIfAbsent(domain, visits);
            }
        }
        final List<String> res = new ArrayList<>();
        cache.forEach((key, value) -> res.add(String.join(" ", value.toString(), key)));
        return res;
    }

    private SubdomainVisitCount() {}
}
