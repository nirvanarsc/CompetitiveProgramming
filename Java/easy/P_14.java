package easy;

public class P_14 {

    public String longestCommonPrefix(String[] strings) {
        if (strings.length == 0) {
            return "";
        }
        String pre = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (!strings[i].startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }
}
