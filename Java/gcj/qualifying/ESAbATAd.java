package gcj.qualifying;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ESAbATAd {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        final int b = in.nextInt();
        for (int k = 1; k <= t; k++) {
            if (b == 10) {
                final StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= b; i++) {
                    System.out.println(i);
                    sb.append(in.nextInt());
                }
                in.nextLine();
                System.out.println(sb);
                final String s = in.nextLine();
                if ("N".equals(s)) {
                    return;
                }
            } else if (b == 20) {
                final StringBuilder sb = new StringBuilder();
                int z = 15;
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    sb.append(in.nextInt());
                }
                z--;
                final String curr = sb.toString();
                sb.setLength(0);
                for (char c : curr.toCharArray()) {
                    sb.append(c == '0' ? '1' : '0');
                }
                final String comp = sb.toString();
                sb.setLength(0);
                while (z > 0) {
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(i);
                        sb.append(in.nextInt());
                    }
                    final String s = sb.toString();
                    z--;
                    if (!s.equals(curr) && !s.equals(comp)) {
                        break;
                    } else {
                        sb.setLength(0);
                    }
                }
                if(z == 0) {
                    in.nextLine();
                    System.out.println(sb);
                    final String s = in.nextLine();
                    if ("N".equals(s)) {
                        return;
                    }
                } else {
                    final String left = sb.toString();
                    sb.setLength(0);
                    for (char c : left.toCharArray()) {
                        sb.append(c == '0' ? '1' : '0');
                    }
                    final String leftComp = sb.toString();
                    int queryIdx1 = -1;
                    int queryIdx2 = -1;
                    for (int i = 0; i < 10; i++) {
                        if (left.charAt(i) != comp.charAt(i)) {
                            queryIdx1 = i;
                        }
                        if (left.charAt(i) != curr.charAt(i)) {
                            queryIdx2 = i;
                        }
                    }
                    System.out.println(queryIdx1 + 1);
                    final int ans1 = in.nextInt();
                    System.out.println(queryIdx2 + 1);
                    final int ans2 = in.nextInt();

                    System.out.println(11);
                }
            }
        }
    }
}
