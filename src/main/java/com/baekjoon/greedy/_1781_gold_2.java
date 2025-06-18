package com.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class _1781_gold_2 {

    static FastReader scan = new FastReader();

    static int n;
    static PriorityQueue<Node> problem = new PriorityQueue<>((o1, o2) -> o2.deadline - o1.deadline);

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            problem.offer(new Node(scan.nextInt(), scan.nextInt()));
        }
    }

    static void solve() {
        PriorityQueue<Node> candidate = new PriorityQueue<>((o1, o2) -> o2.ramen - o1.ramen);

        int time = problem.peek().deadline + 1;
        int result = 0;

        while (--time > 0) {
            while (!problem.isEmpty()) {
                Node node = problem.poll();
                if (time == node.deadline) {
                    candidate.offer(node);
                } else {
                    problem.offer(node);
                    break;
                }
            }

            Node poll = candidate.poll();
            if (poll == null) {
                time = problem.isEmpty() ? 0 : problem.peek().deadline + 1;
                continue;
            }

            result += poll.ramen;
        }

        System.out.println(result);
    }

    static class Node {
        int deadline;
        int ramen;

        public Node(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
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
