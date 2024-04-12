import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int[][] map;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }

    static int max = 0;
    static void solve() {

        recursion(0, 0, 0);

        System.out.println(max);
    }

    static void recursion(int x, int y, int depth) {
        if (depth == 3) {
            int[][] copyArr = new int[n][m];
            for (int i = 0; i < n; i++) {
                copyArr[i] = map[i].clone();
            }
            check(copyArr);
            return;
        }
        for (int i = x; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i!=0 || j!=0) && (i == x && j <= y)) {
                    continue;
                }
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    recursion(i, j, depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void check(int[][] check) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j] == 2) {
                    virus(i, j, check);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j] == 0) {
                    result ++;
                }
            }
        }

        if (result > max) {
            max = result;
        }
    }

    static void virus(int x, int y, int[][] check) {
        check[x][y] = 2;
        if (x - 1 >= 0 && check[x - 1][y] == 0) {
            virus(x-1, y, check);
        }
        if (x + 1 < n && check[x + 1][y] == 0) {
            virus(x + 1, y, check);
        }
        if (y - 1 >= 0 && check[x][y - 1] == 0) {
            virus(x, y - 1, check);
        }
        if (y + 1 < m && check[x][y + 1] == 0) {
            virus(x, y + 1, check);
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
