import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
    }

    static int n;
    static int m;
    static int w;

    static ArrayList<Node> edge;

    static void input() {
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            n = scan.nextInt();
            m = scan.nextInt();
            w = scan.nextInt();

            edge = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int from = scan.nextInt();
                int to = scan.nextInt();
                int weight = scan.nextInt();

                edge.add(new Node(from, to, weight));
                edge.add(new Node(to, from, weight));
            }

            for (int j = 0; j < w; j++) {
                int from = scan.nextInt();
                int to = scan.nextInt();
                int weight = scan.nextInt();

                edge.add(new Node(from, to, -weight));
            }

            solve();
        }

        System.out.println(sb);
    }

    static void solve() {
        int[] distance = new int[n + 1];

        boolean result = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < edge.size(); j++) {
                Node node = edge.get(j);

                if (distance[node.to] > distance[node.from] + node.weight) {
                    distance[node.to] = distance[node.from] + node.weight;
                    if (i == n) {
                        result = true;
                    }
                }
            }
        }

        if (result)
            sb.append("YES").append("\n");
        else
            sb.append("NO").append("\n");
    }


    static class Node implements Comparable<Node> {
        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
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
