package easy;

public class P_482 {

    public String licenseKeyFormattingSmart(String S, int K) {
        final String string = S.replace("-", "").toUpperCase();
        final StringBuilder sb = new StringBuilder(string);
        for(int i = sb.length()-K; i > 0; i -= K){
            sb.insert(i, '-');
        }
        return sb.toString();
    }

    public String licenseKeyFormatting(String S, int K) {
        final StringBuilder sb = new StringBuilder();
        int i = S.length() - 1;
        while (i >= 0) {
            int loop = K;
            while (loop > 0 && i >= 0) {
                char c = S.charAt(i);
                if (c != '-') {
                    if ('a' <= c && c <= 'z') {
                        c |= 32;
                    }
                    sb.append(c);
                    loop--;
                }
                i--;
            }
            sb.append('-');
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
