import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static Table[] tables;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        Arrays.sort(tables, (t1, t2) -> t1.start == t2.start ? t1.end - t2.end : t1.start - t2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(tables[0].end);

        for (int i = 1; i < n; i++) {
            if (tables[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(tables[i].end);
        }

        System.out.println(pq.size());
    }

    static void input() {
        n = scan.nextInt();

        tables = new Table[n];
        for (int i = 0; i < n; i++) {
            tables[i] = new Table(scan.nextInt(), scan.nextInt());
        }
    }

    static class Table {
        int start;
        int end;

        public Table(int start, int end) {
            this.start = start;
            this.end = end;
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

