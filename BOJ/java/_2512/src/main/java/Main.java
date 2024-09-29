import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n, m;
    static int max = 0;
    static int[] budget;

    public static void main(String[] args) {
        n = scan.nextInt();
        budget = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            budget[i] = scan.nextInt();
            max = Math.max(max, budget[i]);
            sum += budget[i];
        }

        m = scan.nextInt();

        if (sum < m) {
            System.out.println(max);
            return;
        }

        solve();
    }

    static void solve() {
        int s = 0;
        int e = max;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (sum(mid)) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        System.out.println(e);
    }

    static boolean sum(int cost) {
        int sum = 0;

        for (Integer b : budget) {
            if (b < cost) {
                sum += b;
            } else {
                sum += cost;
            }
        }

        return sum <= m;
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
