import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int g, p;
    static Queue<Integer> q = new LinkedList<>();
    static int[] parent;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        int result = 0;

        while (!q.isEmpty()) {
            int maxGate = q.poll();

            int dock = find(maxGate);
            if (dock != 0) {
                result++;
                union(dock, dock - 1);
            } else {
                System.out.println(result);
                return;
            }
        }
        System.out.println(result);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX < rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }

    static void input() {
        g = scan.nextInt();
        p = scan.nextInt();

        parent = new int[g + 1];
        for (int i = 1; i <= g; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < p; i++) {
            q.add(scan.nextInt());
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

