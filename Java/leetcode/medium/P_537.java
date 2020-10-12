package leetcode.medium;

public final class P_537 {

    public static String complexNumberMultiply(String first, String second) {
        final String[] splitFirst = first.split("\\+");
        final String[] splitSecond = second.split("\\+");
        final int a = Integer.parseInt(splitFirst[0]);
        final int x = Integer.parseInt(splitFirst[1].substring(0, splitFirst[1].length() - 1));
        final int b = Integer.parseInt(splitSecond[0]);
        final int y = Integer.parseInt(splitSecond[1].substring(0, splitSecond[1].length() - 1));
        final StringBuilder sb = new StringBuilder();
        sb.append(a * b - x * y);
        sb.append('+');
        sb.append(a * y + b * x);
        sb.append('i');
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
        System.out.println(complexNumberMultiply("78+-76i", "-86+72i"));
    }

    private P_537() {}
}
