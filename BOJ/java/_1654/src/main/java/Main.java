import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int k;
    static int[] line;
    static long max;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        k = scan.nextInt();

        line = new int[n];

        for (int i = 0; i < n; i++) {
            line[i] = scan.nextInt();
        }
    }

    static void solve() {
        max = 0;

        long start = 0;
        long end = Integer.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;

            long count = check(mid);

            if (count >= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(max);
    }

    static long check(long dis) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += line[i] / dis;
        }

        if (count >= k && max < dis) {
            max = dis;
        }

        return count;
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
