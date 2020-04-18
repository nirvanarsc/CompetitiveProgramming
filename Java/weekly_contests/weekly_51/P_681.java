package weekly_contests.weekly_51;

import java.util.HashSet;
import java.util.Set;

public class P_681 {

    public String nextClosestTime(String time) {
        final Set<Integer> set = new HashSet<>();
        set.add(time.charAt(0) - '0');
        set.add(time.charAt(1) - '0');
        set.add(time.charAt(3) - '0');
        set.add(time.charAt(4) - '0');

        int hours = Integer.parseInt(time.substring(0, 2));
        int mins = Integer.parseInt(time.substring(3));

        while (true) {
            mins++;
            hours = (hours + mins / 60) % 24;
            mins %= 60;
            if (set.contains(hours / 10) &&
                set.contains(hours % 10) &&
                set.contains(mins / 10) &&
                set.contains(mins % 10)) {
                break;
            }
        }
        return String.format("%02d", hours) + ':' + String.format("%02d", mins);
    }
}
