package easy;

public class P_38 {

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = lookAndSay(s);
        }
        return s;
    }

    public String lookAndSay(String str) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
