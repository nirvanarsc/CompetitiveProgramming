package medium;

public class P_921 {

    public int minAddToMakeValid(String string) {
        int open = 0, closed = 0;

        for (char c : string.toCharArray()) {
            if (c == ')') {
                if (open > 0) {
                    open--;
                } else {
                    closed++;
                }
            } else {
                open++;
            }
        }

        return open + closed;
    }
}
