package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int t;

    public static void main(String[] args) {
        input();
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            test();
        }

        System.out.println(sb.toString());
    }

    static HashMap<String, Integer> name = new HashMap<>();
    static int count;
    static int[] parent;
    static int[] peopleCount;

    static void test() {

        int f = scan.nextInt();
        name.clear();
        count = 0;
        parent = new int[f * 2];
        peopleCount = new int[f * 2];

        for (int i = 0; i < f * 2; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < f; i++) {
            testInput();
        }
    }

    static void testInput() {
        String a = scan.next();
        String b = scan.next();

        int x = getIndex(a);
        int y = getIndex(b);

        if (sb.length() > 0) {
            sb.append("\n");
        }
        sb.append(union(x, y));
    }

    static int getIndex(String s) {
        if (name.containsKey(s)) {
            return name.get(s);
        } else {
            name.put(s, count);
            peopleCount[count++] = 1;
            return count-1;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return peopleCount[x];
        }

        if (x > y) {
            parent[y] = x;
            peopleCount[x] = peopleCount[x] + peopleCount[y];
            return peopleCount[x];
        } else {
            parent[x] = y;
            peopleCount[y] = peopleCount[x] + peopleCount[y];
            return peopleCount[y];
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