import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static int n;
    static int m;

    static List<Integer> have = new ArrayList<>();
    static List<Integer> isHave = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            have.add(scan.nextInt());
        }

        m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            isHave.add(scan.nextInt());
        }
    }

    static void solve() {
        Collections.sort(have);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int result = search(isHave.get(i));
            sb.append(result);
            sb.append(" ");
        }

        System.out.println(sb);
    }

    static int search(int target) {
        int s = 0;
        int e = have.size() - 1;

        while (s <= e) {
            int m = (s + e) / 2;

            if (target == have.get(m)) {
                return 1;
            }

            if (target < have.get(m)) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return 0;
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
