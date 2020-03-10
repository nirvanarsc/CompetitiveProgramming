package weekly_contests.weekly_109;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_936 {

    public static final int[] INTS = new int[0];

    public int[] movesToStamp(String stamp, String target) {
        final char[] targetC = target.toCharArray();
        final char[] stampC = stamp.toCharArray();
        int remainingLength = targetC.length;
        final List<Integer> steps = new ArrayList<>();
        while (remainingLength > 0) {
            boolean found = false;
            for (int i = 0; i <= targetC.length - stampC.length; i++) {
                boolean match = true;
                boolean hasNonQ = false;
                for (int j = 0; j < stampC.length; j++) {
                    if (targetC[i + j] != '?') {
                        if (targetC[i + j] != stampC[j]) {
                            match = false;
                            break;
                        }
                        hasNonQ = true;
                    }
                }
                if (match && hasNonQ) {
                    found = true;
                    steps.add(i);
                    for (int j = 0; j < stampC.length; j++) {
                        if (targetC[i + j] != '?') {
                            targetC[i + j] = '?';
                            remainingLength--;
                        }
                    }
                    break;
                }
            }
            if (!found) {
                return INTS;
            }
        }
        Collections.reverse(steps);
        return steps.stream().mapToInt(Integer::intValue).toArray();
    }
}
