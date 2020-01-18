package easy;

public class P_925 {

    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        int left = 0, right = 0;
        while (left < name.length() && right < typed.length()) {
            if (name.charAt(left) != typed.charAt(right)) {
                return false;
            }
            if (left == name.length() - 1 || name.charAt(left) == name.charAt(left + 1)) {
                left++;
                right++;
            } else {
                while (right < typed.length() && name.charAt(left) == typed.charAt(right)) {
                    right++;
                }
                left++;
            }
        }
        return left == name.length();
    }
}
