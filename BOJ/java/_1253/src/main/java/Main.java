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
        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (isGood(i)) {
                result++;
            }
        }

        System.out.println(result);
    }

    static boolean isGood(int target) {
        int p1 = 0;
        int p2 = n - 1;

        while (p1 < p2) {
            if (p1 == target) {
                p1++;
                continue;
            } else if (p2 == target) {
                p2--;
                continue;
            }

            if (arr[target] == arr[p1] + arr[p2]) {
                return true;
            } else if (arr[target] < arr[p1] + arr[p2]) {
                p2--;
            } else {
                p1++;
            }
        }

        return false;
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

