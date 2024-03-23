package org.example;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        input();
        System.out.println(sb.toString());
    }
    static void input(){
        n = scan.nextInt();

        arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        m = scan.nextInt();
        for (int i=0;i<m;i++){
            solve(scan.nextInt());
        }
    }
    static void solve(int x){
        int start = 0;
        int end = n-1;
        int result = 0;
        while(start<=end){
            int mid = (start+end)/2;

            if (x==arr[mid]){
                result = 1;
                break;
            }else if (x<arr[mid]){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        if (sb.length()>0){
            sb.append("\n");
        }
        sb.append(result);
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
