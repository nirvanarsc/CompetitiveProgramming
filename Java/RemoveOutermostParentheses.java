public final class RemoveOutermostParentheses {

    private static String removeOuterParentheses(String s) {
        int openParentheses = 0;
        final StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (openParentheses != 0) {
                    res.append(s.charAt(i));
                }
                openParentheses++;
            }
            if (s.charAt(i) == ')') {
                openParentheses--;
                if (openParentheses != 0) {
                    res.append(s.charAt(i));
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()"));
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
