import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static char[] arr;

    static int[] numarr;
    static char[] oparr;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        arr = scan.next().toCharArray();

        numarr = new int[n / 2 + 1];
        oparr = new char[n / 2];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                numarr[i / 2] = Integer.parseInt(String.valueOf(arr[i]));
            } else {
                oparr[i / 2] = arr[i];
            }
        }
    }

    static int max = Integer.MIN_VALUE;

    static void solve() {
        recursion(0, "");
        System.out.println(max);
    }

    static void recursion(int index, String s) {
        if (index == numarr.length - 1) {
            check(s + numarr[index]);
            return;
        }else if (index > numarr.length - 1) {
            check(s);
            return;
        }
        recursion(index + 1, s + numarr[index] + oparr[index]);
        if (index < numarr.length - 2) {
            recursion(index + 2, s + "(" + numarr[index] + oparr[index] + numarr[index + 1] + ")" + oparr[index + 1]);
        } else if (index == numarr.length -2){
            recursion(index + 2, s + "(" + numarr[index] + oparr[index] + numarr[index + 1] + ")");
        }
    }

    static void check(String s) {
        char[] carr = s.toCharArray();

        List<String> filtered = new ArrayList<>();
        for (int i = 0; i < carr.length; i++) {
            if (carr[i] == '(') {
                if (carr[i + 2] == '+') {
                    int cal = (carr[i + 1] - '0') + (carr[i + 3] - '0');
                    filtered.add(String.valueOf(cal));
                }else if (carr[i + 2] == '-') {
                    int cal = (carr[i + 1] - '0') - (carr[i + 3] - '0');
                    filtered.add(String.valueOf(cal));
                }else {
                    int cal = (carr[i + 1] - '0') * (carr[i + 3] - '0');
                    filtered.add(String.valueOf(cal));
                }
                i+=4;
            }else {
                filtered.add(String.valueOf(carr[i]));
            }
        }

        int tmp = Integer.parseInt(filtered.get(0));
        for (int i = 1; i < filtered.size(); i+=2) {
            if (filtered.get(i).equals("+")) {
                tmp += Integer.parseInt(filtered.get(i + 1));
            } else if (filtered.get(i).equals("-")) {
                tmp -= Integer.parseInt(filtered.get(i + 1));
            } else {
                tmp *= Integer.parseInt(filtered.get(i + 1));
            }
        }

        if (max < tmp) {
            max = tmp;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
