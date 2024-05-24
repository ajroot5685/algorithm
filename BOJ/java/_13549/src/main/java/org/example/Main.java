package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int k;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[]{n, 0});
        boolean[] visited = new boolean[100_001];

        int count = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int pos = now[0];
            count = now[1];

            if (pos == k) {
                break;
            }

            visited[pos] = true;
            if (pos * 2 <= 100_000 && !visited[pos * 2]) {
                pq.offer(new int[]{pos * 2, count});
            }
            if (pos < k && pos + 1 <= 100_000 && !visited[pos + 1]) {
                pq.offer(new int[]{pos + 1, count + 1});
            }
            if (pos - 1 >= 0 && !visited[pos - 1]) {
                pq.offer(new int[]{pos - 1, count + 1});
            }
        }

        System.out.println(count);
    }

    static void input() {
        n = scan.nextInt();
        k = scan.nextInt();
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