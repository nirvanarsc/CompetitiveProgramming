package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_247 {

    /*
     * 1 = ["0","1","8"]
     * 2 = ["11","69","88","96"]
     * 3 = ["101","111","181","609","619","689","808","818","888","906","916","986"]
     * 4 = ["1001","1111","1691","1881","1961","6009","6119","6699","6889","6969","8008","8118","8698","8888","8968","9006","9116","9696","9886","9966"]
     * 5 = ["10001","10101","10801","11011","11111","11811","16091","16191","16891","18081","18181","18881","19061","19161","19861",
     * "60009","60109","60809","61019","61119","61819","66099","66199","66899","68089","68189","68889","69069","69169","69869",
     * "80008","80108","80808","81018","81118","81818","86098","86198","86898","88088","88188","88888","89068","89168","89868",
     * "90006","90106","90806","91016","91116","91816","96096","96196","96896","98086","98186","98886","99066","99166","99866"]
     */
    public List<String> findStrobogrammatic(int n) {
        return recurse(n, false);
    }

    private static List<String> recurse(int n, boolean addZero) {
        if (n == 0) {
            return new ArrayList<>(Collections.singletonList(""));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }

        final List<String> list = recurse(n - 2, true);
        final List<String> res = new ArrayList<>();

        for (String s : list) {
            if (addZero) {
                res.add('0' + s + '0');
            }
            res.add('1' + s + '1');
            res.add('6' + s + '9');
            res.add('8' + s + '8');
            res.add('9' + s + '6');
        }

        return res;
    }
}
