package com.swea.d3;

import java.io.*;
import java.util.*;

public class _1215 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;
    static char[][] map;

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = 10;

        for (int i = 1; i <= t; i++) {
            n = scan.nextInt();
            map = new char[8][8];

            for (int j = 0; j < 8; j++) {
                char[] charArray = scan.next().toCharArray();
                for (int k = 0; k < 8; k++) {
                    map[j][k] = charArray[k];
                }
            }

            sb.append("#").append(i).append(" ");
            solve();
        }
    }

    static void solve() {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8 - n + 1; j++) {
                if (isPalindrome(i, j, 0)) {
                    count++;
                }
            }
        }

        for (int i = 0; i < 8 - n + 1; i++) {
            for (int j = 0; j < 8; j++) {
                if (isPalindrome(i, j, 1)) {
                    count++;
                }
            }
        }

        sb.append(count).append("\n");
    }

    static boolean isPalindrome(int x, int y, int direction) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (n % 2 == 1 && i == n / 2) {
                x += dx[direction];
                y += dy[direction];
                continue;
            }
            if (i < n / 2) {
                stack.push(map[x][y]);
            } else {
                if (stack.pop() != map[x][y]) {
                    return false;
                }
            }
            x += dx[direction];
            y += dy[direction];
        }
        return true;
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
