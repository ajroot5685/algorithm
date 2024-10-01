import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n, k, l;
    static int[][] map; // 0: 아무것도 없는 땅, 1: 사과, 2: 뱀, 3: 벽
    static Queue<DirTrans> queue = new LinkedList<>();
    static Deque<Snake> snake = new ArrayDeque<>(); // 뱀 전체 위치 저장

    static int[] head = {1, 1};

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        snake.offerFirst(new Snake(1, 1));

        DirTrans next = queue.poll();
        int nowDir = 0; // 0:오, 1:아, 2:왼, 3:위

        int result = 0; // 끝난 시간
        while (true) {
            result++;

            // 디버그용
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < n + 2; i++) {
//                for (int j = 0; j < n + 2; j++) {
//                    sb.append(map[i][j]).append(" ");
//                }
//                sb.append("\n");
//            }
//            System.out.println(sb);
//            System.out.println(next);

            // 이동
            int move = move(nowDir);
            snake.offerFirst(new Snake(head[0], head[1]));

            // 게임 끝인지 확인
            if (move == 3 || move == 2) {
                break;
            }

            // 꼬리 작업(사과 못먹었을 때)
            if (move != 1) {
                Snake tail = snake.pollLast();
                assert tail != null;
                map[tail.row][tail.column] = 0;
            }

            // 방향 전환
            if (next != null && next.time == result) {
                if (next.dir.equals("L")) {
                    nowDir = (nowDir + 4 - 1) % 4;
                } else {
                    nowDir = (nowDir + 1) % 4;
                }
                next = queue.poll();
            }
        }

        System.out.println(result);
    }

    static int move(int m) { // 이동한 칸에 무엇이 있었는지 반환
        int tmp;
        switch(m) {
            case 0: // 오른
                tmp = map[head[0]][head[1] + 1];
                map[head[0]][head[1] + 1] = 2;
                head[1]++;
                return tmp;
            case 1: // 아래
                tmp = map[head[0] + 1][head[1]];
                map[head[0] + 1][head[1]] = 2;
                head[0]++;
                return tmp;
            case 2: // 왼
                tmp = map[head[0]][head[1] - 1];
                map[head[0]][head[1] - 1] = 2;
                head[1]--;
                return tmp;
            case 3: // 위
                tmp = map[head[0] - 1][head[1]];
                map[head[0] - 1][head[1]] = 2;
                head[0]--;
                return tmp;
            default:
                return -100;
        }
    }

    static void input() {
        n = scan.nextInt();

        map = new int[n + 2][n + 2]; // 가장자리 비워서 벽으로 사용
        map[1][1] = 2;
        k = scan.nextInt();

        for (int i = 0; i < k; i++) {
            int row = scan.nextInt();
            int column = scan.nextInt();
            map[row][column] = 1;
        }

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (i == 0 || j == 0 || i == n + 1 || j == n + 1) {
                    map[i][j] = 3; // 벽
                }
            }
        }

        l = scan.nextInt();
        for (int i = 0; i < l; i++) {
            int time = scan.nextInt();
            String dir = scan.next();

            DirTrans dirTrans = new DirTrans(time, dir);
            queue.add(dirTrans);
        }
    }

    static class Snake {
        int row;
        int column;

        public Snake(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    static class DirTrans {
        int time;
        String dir;

        public DirTrans(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return this.time + " " + this.dir;
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

