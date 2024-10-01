import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int[] arr;
    static int x;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        Arrays.sort(arr);

        int result = 0;

        int p1 = 0;
        int p2 = n - 1;

        while (p1 < p2) {
            int sum = arr[p1] + arr[p2];
            if (sum == x) {
                result++;
                p1++;
            } else if (sum < x) {
                p1++;
            } else {
                p2--;
            }
        }

        System.out.println(result);
    }

    static void input() {
        n = scan.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        x = scan.nextInt();
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
