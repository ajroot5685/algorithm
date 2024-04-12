import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int r;
    static int c;
    static int n;

    static int[][] map;
    static int[][] visit;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        r = scan.nextInt();
        c = scan.nextInt();
        n = scan.nextInt();

        map = new int[r][c];
        visit = new int[r][c];

        char[] tmp;
        for (int i = 0; i < r; i++) {
            tmp = scan.next().toCharArray();

            for (int j = 0; j < c; j++) {
                if (tmp[j] == '.') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 2;
                }
            }
        }
    }

    static void solve() {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    map[j][k]++;
                }
            }
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    check(j, k);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0) {
                    sb.append('.');
                } else {
                    sb.append('O');
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void check(int x, int y) {
        visit[x][y] = 1;
        if (map[x][y] == 4) {
            if (x - 1 >= 0 && visit[x-1][y] == 0) {
                check(x - 1, y);
                map[x - 1][y] = 0;
            }
            if (x + 1 < r && visit[x+1][y] == 0) {
                check(x + 1, y);
                map[x + 1][y] = 0;
            }
            if (y - 1 >= 0 && visit[x][y-1] == 0) {
                check(x, y - 1);
                map[x][y - 1] = 0;
            }
            if (y + 1 < c && visit[x][y+1] == 0) {
                check(x, y + 1);
                map[x][y + 1] = 0;
            }
            map[x][y] = 0;
        }
        visit[x][y] = 0;
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
