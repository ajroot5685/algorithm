package org.example;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static StringBuilder sb = new StringBuilder();

    static int n;
    static long[] arr;

    static long liquid1;
    static long liquid2;
    static long liquid3;
    static long close = Long.MAX_VALUE;

    public static void main(String[] args) {
        input();
        solve();
        sb.append(liquid1);
        sb.append(" ");
        sb.append(liquid2);
        sb.append(" ");
        sb.append(liquid3);
        System.out.println(sb.toString());
    }
    static void input(){
        n = scan.nextInt();

        arr = new long[n];

        for (int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
    }
    static void solve(){
        Arrays.sort(arr);

        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                bs(i, j);
            }
        }
    }

    static void bs(int i, int j){
        int start = j+1;
        int end = n-1;

        while(start<=end){
            int mid = (start+end)/2;

            long sum = arr[i] + arr[j] + arr[mid];

            if (sum==0){
                close = sum;
                liquid1 = arr[i];
                liquid2 = arr[j];
                liquid3 = arr[mid];
                return;
            }
            if (isclose(sum)) {
                close = sum;
                liquid1 = arr[i];
                liquid2 = arr[j];
                liquid3 = arr[mid];
            }
            if (sum>0){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
    }
    static boolean isclose(long x){
        if (Math.abs(close)>Math.abs(x)){
            return true;
        }else{
            return false;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}