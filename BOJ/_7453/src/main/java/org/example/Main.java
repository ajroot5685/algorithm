package org.example;


import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static StringBuilder sb = new StringBuilder();
    static int n;

    static int[] a;
    static int[] b;
    static int[] c;
    static int[] d;

    static int[] arr1;
    static int[] arr2;

    static long result = 0;

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(result);
    }
    static void input(){
        n = scan.nextInt();

        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];

        for(int i=0;i<n;i++){
            a[i] = scan.nextInt();
            b[i] = scan.nextInt();
            c[i] = scan.nextInt();
            d[i] = scan.nextInt();
        }

        arr1 = new int[n*n];
        arr2 = new int[n*n];
    }
    static void solve(){
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                arr1[i*n+j]=a[i]+b[j];
                arr2[i*n+j]=c[i]+d[j];
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int j=0;j<arr1.length;j++){
            int up = upperBound(-arr1[j]);
            int lo = lowerBound(-arr1[j]);
            result+=(up-lo);
        }
    }
    static int upperBound(int target){
        int s = 0;
        int e = arr2.length-1;

        while (s<=e){
            int mid = (s+e)/2;
            if (arr2[mid]>target){
                e = mid-1;
            }else {
                s = mid+1;
            }
        }
        return e;
    }
    static int lowerBound(int target){
        int s = 0;
        int e = arr2.length-1;

        while (s<=e){
            int mid = (s+e)/2;
            if (arr2[mid]>=target){
                e = mid-1;
            }else {
                s = mid+1;
            }
        }
        return e;
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
