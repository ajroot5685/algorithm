package org.example;


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        input();
        solve();
    }
    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();

        arr = new int[n];

        for (int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

    }
    static void solve(){
        int start = 0;
        int end = 10000 * (n/m);
        int result = end;

        while(start<=end){
            int mid = (start+end)/2;

            boolean in = insert(mid);

            if (in){
                end = mid-1;
                result = mid;
            }else{
                start = mid+1;
            }
        }

        System.out.println(result);
    }
    static boolean insert(int size){
        int[] tape = new int[m];

        int index = 0;

        for (int i=0;i<m;i++){
            while(tape[i]+arr[index]<=size){
                tape[i]+=arr[index++];

                if (index>=n){
                    return true;
                }
            }
        }

        return false;
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