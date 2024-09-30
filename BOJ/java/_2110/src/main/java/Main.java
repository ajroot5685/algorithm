import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int c;
    static int[] home;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        Arrays.sort(home);

        int start = 0;
        int end = home[n - 1] - home[0];

        while (start <= end) {
            int mid = (start + end) / 2;

            if (isAble(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }

    static boolean isAble(int distance) {
        int remain = c;

        int prevPos = home[0];
        remain--;

        for (int i = 1; i < n; i++) {
            if (home[i] - distance >= prevPos) {
                remain--;
                prevPos = home[i];
            }
            if (remain == 0) {
                return true;
            }
        }

        return false;
    }

    static void input() {
        n = scan.nextInt();
        c = scan.nextInt();

        home = new int[n];

        for (int i = 0; i < n; i++) {
            home[i] = scan.nextInt();
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
