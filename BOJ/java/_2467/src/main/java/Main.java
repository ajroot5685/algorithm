import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        int distance = Integer.MAX_VALUE;
        int[] result = {0, 0};

        int p1 = 0;
        int p2 = n - 1;

        while (p1 < p2) {
            int sum = arr[p1] + arr[p2];

            if (Math.abs(sum) < distance) {
                distance = Math.abs(sum);
                result[0] = arr[p1];
                result[1] = arr[p2];
                Arrays.sort(result);
            }

            if (sum == 0) {
                System.out.println(result[0] + " " + result[1]);
                return;
            } else if (sum < 0) {
                p1++;
            } else {
                p2--;
            }
        }

        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1]);
    }

    static void input() {
        n = scan.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
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
