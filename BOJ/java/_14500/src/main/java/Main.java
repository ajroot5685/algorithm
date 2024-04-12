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

    static int[][][][] shape = {
            {
                    {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
                    {{0, 0}, {1, 0}, {2, 0}, {3, 0}}
            },
            {
                    {{0, 0}, {0, 1}, {1, 0}, {1, 1}}
            },
            {
                    {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
                    {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
                    {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
                    {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
                    {{0, 0}, {0, 1}, {-1, 1}, {-2, 1}},
                    {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
                    {{0, 0}, {1, 0}, {2, 0}, {0, 1}},
                    {{0, 0}, {0, 1}, {0, 2}, {1, 2}}
            },
            {
                    {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
                    {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
                    {{0, 0}, {-1, 0}, {-1, 1}, {-2, 1}},
                    {{0, 0}, {0, 1}, {1, 1}, {1, 2}}
            },
            {
                    {{0, 0}, {0, 1}, {1, 1}, {0, 2}},
                    {{0, 0}, {0, 1}, {-1, 1}, {1, 1}},
                    {{0, 0}, {0, 1}, {-1, 1}, {0, 2}},
                    {{0, 0}, {-1, 0}, {1, 0}, {0, 1}}
            }
    };

    static int max = 0;

    static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check(i, j);
            }
        }
        System.out.println(max);
    }

    static void check(int x, int y) {
        int tmp;
        boolean flag;
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                tmp = 0;
                flag = false;
                for (int k = 0; k < 4; k++) {
                    int checkX = shape[i][j][k][0] + x;
                    int checkY = shape[i][j][k][1] + y;
                    if (checkX >= 0 && checkX < n && checkY >= 0 && checkY < m) {
                        tmp += map[checkX][checkY];
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (!flag && (max < tmp)) {
                    max = tmp;
                }
            }
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
