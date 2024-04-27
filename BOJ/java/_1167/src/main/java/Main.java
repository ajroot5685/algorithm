import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int v;
    static ArrayList<Node>[] edge;
    static int max;
    static int end;
    static boolean[] visited;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        max = 0;
        end = -1;

        visited = new boolean[v + 1];
        dfs(1, 0);

        visited = new boolean[v + 1];
        dfs(end, 0);

        System.out.println(max);
    }

    static void dfs(int now, int sum) {
        if (sum > max) {
            end = now;
            max = sum;
        }

        visited[now] = true;

        for (int i = 0; i < edge[now].size(); i++) {
            Node next = edge[now].get(i);

            if (!visited[next.to]) {
                dfs(next.to, sum + next.weight);
            }
        }
    }

    static void input() {
        v = scan.nextInt();

        edge = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 1; i <= v; i++) {
            int from = scan.nextInt();
            while (true) {
                int to = scan.nextInt();
                if (to == -1)
                    break;

                int weight = scan.nextInt();
                edge[from].add(new Node(to, weight));
                edge[to].add(new Node(from, weight));
            }
        }
    }

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
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
