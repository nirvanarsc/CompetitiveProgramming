package medium;

public class P_165 {

    public int compareVersion(String version1, String version2) {
        final String[] split1 = version1.split("\\.");
        final String[] split2 = version2.split("\\.");
        for (int i = 0; i < Math.max(split1.length, split2.length); i++) {
            final int left = i < split1.length ? Integer.parseInt(split1[i]) : 0;
            final int right = i < split2.length ? Integer.parseInt(split2[i]) : 0;
            if (left < right) {
                return -1;
            } else if (left > right) {
                return 1;
            }
        }
        return 0;
    }
}
