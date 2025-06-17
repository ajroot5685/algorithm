package com.baekjoon.samsung;

import java.io.*;
import java.util.*;

public class _14891_gold_5 {

    static FastReader scan = new FastReader();

    static int k;

    static ArrayList<Integer>[] wheel;

    public static void main(String[] args) {
        input();
        printScore();
    }

    static void input() {
        wheel = new ArrayList[5];

        for (int i = 1; i <= 4; i++) {
            String s = scan.next();
            wheel[i] = new ArrayList<>();
            for (char c : s.toCharArray()) {
                wheel[i].add(c - '0');
            }
        }

        k = scan.nextInt();
        for (int i = 0; i < k; i++) {
            solve(scan.nextInt(), scan.nextInt());
        }
    }

    static void solve(int num, int direction) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(num, direction));

        boolean[] visited = new boolean[5];
        visited[num] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int nowNum = poll.num;

            int right = wheel[nowNum].get(2);
            int left = wheel[nowNum].get(6);

            if (nowNum > 1 && !visited[nowNum - 1] && wheel[nowNum - 1].get(2) != left) {
                visited[nowNum - 1] = true;
                queue.offer(new Node(nowNum - 1, -poll.direction));
            }
            if (nowNum < 4 && !visited[nowNum + 1] && wheel[nowNum + 1].get(6) != right) {
                visited[nowNum + 1] = true;
                queue.offer(new Node(nowNum + 1, -poll.direction));
            }

            if (poll.direction == 1) {
                wheel[nowNum].add(0, wheel[nowNum].remove(7));
            } else {
                wheel[nowNum].add(7, wheel[nowNum].remove(0));
            }
        }
    }

    static void printScore() {
        int score = 0;
        if (wheel[1].get(0) == 1) {
            score += 1;
        }
        if (wheel[2].get(0) == 1) {
            score += 2;
        }
        if (wheel[3].get(0) == 1) {
            score += 4;
        }
        if (wheel[4].get(0) == 1) {
            score += 8;
        }

        System.out.println(score);
    }

    static class Node {
        int num;
        int direction;

        public Node(int num, int direction) {
            this.num = num;
            this.direction = direction;
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
