package org.example;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int v;
    static int e;

    static int[] parent;
    static int result;
    static PriorityQueue<Node> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        v = scan.nextInt();
        e = scan.nextInt();

        parent = new int[v + 1];

        for (int i = 1; i < v + 1; i++) {
            parent[i]=i;
        }

        for (int i=0;i<e;i++){
            queue.add(new Node(scan.nextInt(), scan.nextInt(), scan.nextInt()));
        }
    }

    static void solve() {
        result = 0;

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if (union(n.from, n.to)) {
                continue;
            }
            result += n.weight;
        }
        System.out.println(result);
    }

    static int find(int x) {
        if (parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return true;
        }

        if (rootX > rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
        return false;
    }

    static class Node implements Comparable<Node>{
        int from;
        int to;
        int weight;

        public Node(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.weight = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
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