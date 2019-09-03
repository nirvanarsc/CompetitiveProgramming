import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        final Comparator<String> myComp = (s1, s2) -> {
            final int s1si = s1.indexOf(' ');
            final int s2si = s2.indexOf(' ');
            final char s1fc = s1.charAt(s1si + 1);
            final char s2fc = s2.charAt(s2si + 1);

            if (s1fc <= '9') {
                if (s2fc <= '9') {
                    return 0;
                } else {
                    return 1;
                }
            }
            if (s2fc <= '9') {
                return -1;
            }

            final int preCompute = s1.substring(s1si + 1).compareTo(s2.substring(s2si + 1));
            if (preCompute == 0) {
                return s1.substring(0, s1si).compareTo(s2.substring(0, s2si));
            }
            return preCompute;
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}
