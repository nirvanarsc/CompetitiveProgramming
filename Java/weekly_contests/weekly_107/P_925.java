package weekly_contests.weekly_107;

public class P_925 {

    public boolean isLongPressedName(String name, String typed) {
        int ti = 0, ni = 0;
        while (ni < name.length() && ti < typed.length()) {
            if (name.charAt(ni) == typed.charAt(ti)) {
                ni++;
            }
            ti++;
        }
        return ni == name.length();
    }
}
