
import java.io.*;
import java.util.*;
public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int t;

    public static void main(String[] args) {
        input();
        System.out.println(sb.toString());
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            test();
        }
    }

    static int n;
    static int[] parent;
    static int[] distance;

    static void test() {
        n = scan.nextInt();

        parent = new int[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        solve();
    }

    static void solve() {
        while (true) {
            String s = scan.next();

            if (s.equals("O")) {
                return;
            }

            if (s.equals("E")) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                int target = scan.nextInt();
                find(target);
                sb.append(distance[target]);
            } else {
                union(scan.nextInt(), scan.nextInt());
            }
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        int tmp = find(parent[x]);
        distance[x] += distance[parent[x]];
        return parent[x] = tmp;
    }

    static void union(int center, int company) {
        parent[center] = company;
        distance[center] = Math.abs(center - company) % 1000;
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