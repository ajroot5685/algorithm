package com.swea.d3;

import java.io.*;
import java.util.*;

public class _1244 {

    static FastReader scan = new FastReader();

    static int t;
    static int[] arr;
    static int change;

    static int max;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 1; i <= t; i++) {
            String num = scan.next();
            arr = new int[num.length()];
            for (int j = 0; j < num.length(); j++) {
                arr[j] = num.charAt(j) - '0';
            }

            change = scan.nextInt();

            sb.append("#").append(i).append(" ");
            solve();
        }
    }

    static void solve() {
        max = 0;
        if (change >= 5) {
            Arrays.sort(arr);
            for (int i = 0; i < arr.length / 2; i++) {
                int tmp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = tmp;
            }
            dfs(5);
        } else {
            dfs(0);
        }
        sb.append(max).append("\n");
    }

    static void dfs(int tryCount) {
        if (tryCount == change) {
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                result = result * 10 + arr[i];
            }

            max = Math.max(max, result);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(i, j);
                dfs(tryCount + 1);
                swap(j, i);
            }
        }
    }

    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
