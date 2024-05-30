import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        solve();
    }

    static int n;
    static int m;
    static int[][] map;
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static void solve() {
        PriorityQueue<Case> pq = new PriorityQueue<>((o1, o2) -> {return o1.distance - o2.distance;});

        boolean[][][] visited = new boolean[n + 1][m + 1][2];

        pq.add(new Case(1, 1, 1, 1));
        visited[1][1][1] = true;

        while (!pq.isEmpty()) {
            Case c = pq.poll();

            if (c.x == n && c.y == m) {
                System.out.println(c.distance);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int dx = c.x + d[i][0];
                int dy = c.y + d[i][1];

                if (dx >= 1 && dx <= n && dy >= 1 && dy <= m) {
                    if (map[dx][dy] == 0 && !visited[dx][dy][c.crash]) {
                        visited[dx][dy][c.crash] = true;
                        pq.add(new Case(dx, dy, c.distance + 1, c.crash));
                    } else if (map[dx][dy] == 1 && c.crash == 1 && !visited[dx][dy][0]) {
                        visited[dx][dy][0] = true;
                        pq.add(new Case(dx, dy, c.distance + 1, 0));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        map = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = scan.nextLine();
            char[] chars = s.toCharArray();

            for (int j = 1; j <= m; j++) {
                map[i][j] = chars[j - 1] - '0';
            }
        }
    }

    static class Case {
        int x;
        int y;
        int distance;
        int crash;

        public Case(int x, int y, int distance, int crash) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.crash = crash;
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}