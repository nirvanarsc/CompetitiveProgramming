public class RemoveOutermostParentheses {
    private static String removeOuterParentheses(String S) {
        int openParentheses = 0;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (openParentheses != 0) {
                    res.append(S.charAt(i));
                }
                openParentheses++;
            }
            if (S.charAt(i) == ')') {
                openParentheses--;
                if (openParentheses != 0) {
                    res.append(S.charAt(i));
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
