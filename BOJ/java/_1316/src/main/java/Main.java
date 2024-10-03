import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int result = 0;

    public static void main(String[] args) {
        input();
    }

    static void solve(String s) {
        boolean[] check = new boolean[26];

        char prev = '\0';

        for (char c : s.toCharArray()) {
            if (prev != '\0' && prev != c && check[c - 'a']) {
                return;
            } else {
                check[c - 'a'] = true;
                prev = c;
            }
        }
        result++;
    }

    static void input() {
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            solve(scan.next());
        }

        System.out.println(result);
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

