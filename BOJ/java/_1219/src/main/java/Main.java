import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int start;
    static int end;
    static int m;

    static ArrayList<Node> edge;
    static int[] earn;
    static ArrayDeque<Node>[] bfsEdge;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        long[] money = new long[n];
        Arrays.fill(money, Long.MIN_VALUE);

        money[start] = earn[start];

        for (int i = 0; i < n; i++) {
            for (Node node : edge) {
                if (money[node.from] == Long.MIN_VALUE) {
                    continue;
                }
                if (money[node.to] < money[node.from] + node.cost) {
                    money[node.to] = money[node.from] + node.cost;

                    if (i == n - 1) {
                        if (bfs(node.to)) {
                            System.out.println("Gee");
                            return;
                        }
                    }
                }
            }
        }

        if (money[end] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else {
            System.out.println(money[end]);
        }
    }

    static boolean bfs(int start) {
        Queue<Node> bfsQ = new LinkedList<>();

        bfsQ.add(new Node(-1, start, 0));

        boolean[] visited = new boolean[n];

        while (!bfsQ.isEmpty()) {
            Node node = bfsQ.poll();

            if (node.to == end) {
                return true;
            }

            if (visited[node.to]) {
                continue;
            }
            visited[node.to] = true;

            for (Node next : bfsEdge[node.to]) {
                if (!visited[next.to]) {
                    bfsQ.add(next);
                }
            }
        }

        return false;
    }

    static void input() {
        n = scan.nextInt();
        start = scan.nextInt();
        end = scan.nextInt();
        m = scan.nextInt();

        edge = new ArrayList<>();

        // queue for bfs
        bfsEdge = new ArrayDeque[n];
        for (int i = 0; i < n; i++) {
            bfsEdge[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            long cost = scan.nextInt();

            Node node = new Node(from, to, -cost);

            edge.add(node);
            bfsEdge[from].add(node);
        }

        earn = new int[n];

        for (int i = 0; i < n; i++) {
            earn[i] = scan.nextInt();
        }

        int size = edge.size();
        for (int i = 0; i < size; i++) {
            edge.get(i).add(earn[edge.get(i).to]);
        }
    }

    static class Node {
        int from;
        int to;
        long cost;

        public Node(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public void add(long x) {
            this.cost += x;
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
