public final class RobotReturnOrigin {

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LL"));
    }

    private static boolean judgeCircle(String moves) {
        int v = 0, h = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    v++;
                    break;
                case 'D':
                    v--;
                    break;
                case 'R':
                    h++;
                    break;
                case 'L':
                    h--;
            }
        }
        return v == 0 && h == 0;
    }
}
