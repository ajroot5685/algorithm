package org.example;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static char[] a;
    static char[] b;

    static int lenA;
    static int lenB;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        a = scan.next().toCharArray();
        b = scan.next().toCharArray();

        lenA = a.length;
        lenB = b.length;

        dp = new int[lenA+1][lenB+1];
    }

    static void solve() {
        for (int i=1;i<=lenA;i++){
            for (int j=1;j<=lenB;j++){
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[lenA][lenB]);
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements() ){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
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