package leetcode.weekly_contests.weekly_0_99.weekly_78;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P_811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        final Map<String, Integer> map = new HashMap<>();
        for (String d : cpdomains) {
            final int space = d.indexOf(' ');
            final int times = Integer.parseInt(d.substring(0, space));
            final String domain = d.substring(space + 1);
            map.merge(domain, times, Integer::sum);
            int dot = domain.indexOf('.');
            while (dot != -1) {
                map.merge(domain.substring(dot + 1), times, Integer::sum);
                dot = domain.indexOf('.', dot + 1);
            }
        }
        return map.entrySet()
                  .stream()
                  .map(entry -> entry.getValue() + " " + entry.getKey())
                  .collect(Collectors.toList());
    }
}
