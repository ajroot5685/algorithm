import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int[] rope;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        Arrays.sort(rope);

        int max = 0;

        for (int i = 0; i < rope.length; i++) {
            int total = n - i;
            max = Math.max(max, rope[i] * total);
        }

        System.out.println(max);
    }

    static void input() {
        n = scan.nextInt();
        rope = new int[n];
        for (int i = 0; i < n; i++) {
            rope[i] = scan.nextInt();
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

