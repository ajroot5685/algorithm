package com.baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class _15686_gold_5 {

    static FastReader scan = new FastReader();

    static int n, m;
    static List<Node> chickens = new ArrayList<>();
    static List<Node> homes = new ArrayList<>();

    static boolean[] chickenSurvive;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int next = scan.nextInt();
                if (next == 1) {
                    homes.add(new Node(i, j));
                }
                if (next == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }
    }

    static void solve() {
        chickenSurvive = new boolean[chickens.size()];

        for (int i = 0; i < chickens.size(); i++) {
            chickenSurvive[i] = true;
            back(i, 1);
            chickenSurvive[i] = false;
        }

        System.out.println(result);
    }

    static void back(int index, int count) {
        if (count == m) {
            int chickenDistance = calculateChickenDistance();
            result = Math.min(result, chickenDistance);
            return;
        }

        for (int i = index + 1; i < chickens.size(); i++) {
            chickenSurvive[i] = true;
            back(i, count + 1);
            chickenSurvive[i] = false;
        }
    }

    static int calculateChickenDistance() {
        int result = 0;
        for (Node home : homes) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < chickenSurvive.length; i++) {
                if (chickenSurvive[i]) {
                    Node chicken = chickens.get(i);
                    int distance = Math.abs(chicken.x - home.x) + Math.abs(chicken.y - home.y);
                    min = Math.min(min, distance);
                }
            }
            result += min;
        }
        return result;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
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
