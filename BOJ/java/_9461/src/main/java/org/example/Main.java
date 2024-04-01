package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) {
        input();
    }

    static int t;
    static long[] arr;
    static void input(){
        t = scan.nextInt();

        arr = new long[101];
        dp();

        for (int i=0;i<t;i++){
            System.out.println(arr[scan.nextInt()]);
        }
    }
    static void dp(){
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for (int i=3;i<101;i++){
            arr[i] = arr[i-3]+arr[i-2];
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