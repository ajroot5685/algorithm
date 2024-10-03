import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        solve();
    }

    static void solve() {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.offer(new Pos(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Pos pos = pq.poll();

            if (pos.x == n - 1 && pos.y == m - 1) {
                System.out.println(pos.wall);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = pos.x + dx[i];
                int nextY = pos.y + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }

                if (!visited[nextX][nextY]) {
                    if (map[nextX][nextY] == 1) {
                        pq.offer(new Pos(nextX, nextY, pos.wall + 1));
                    } else {
                        pq.offer(new Pos(nextX, nextY, pos.wall));
                    }
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    static class Pos implements Comparable<Pos> {
        int x;
        int y;
        int wall;

        public Pos(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }

        @Override
        public int compareTo(Pos o) {
            return this.wall - o.wall;
        }
    }
}

