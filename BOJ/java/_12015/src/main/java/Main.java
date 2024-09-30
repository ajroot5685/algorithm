import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int[] arr;

    static List<Integer> result = new ArrayList<>();

    public static void main(String args[]) {
        input();
        solve();
    }

    static void solve() {
        for (int i = 0; i < n; i++) {
            bs(arr[i]);
        }

        System.out.println(result.size());
    }

    static void bs(int next) {
        if (result.size() == 0) {
            result.add(next);
            return;
        }

        int start = 0;
        int end = result.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (result.get(mid) == next) {
                return;
            }
            if (result.get(mid) < next) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (start >= result.size()) {
            result.add(next);
        } else {
            result.set(start, next);
        }
    }

    static void input(){
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
