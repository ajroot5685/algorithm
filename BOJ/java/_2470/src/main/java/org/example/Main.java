package org.example;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;
    static int liquid1;
    static int liquid2;
    static int sum;

    public static void main(String[] args) {
        input();
        solve();
        sb.append(liquid1);
        sb.append(" ");
        sb.append(liquid2);
        System.out.println(sb.toString());
    }
    static void input(){
        n = scan.nextInt();

        arr = new int[n];

        for (int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
    }
    static void solve(){
        Arrays.sort(arr);

        if(arr[0] <= 0 && arr[n-1]<=0){
            liquid1 = arr[n-2];
            liquid2 = arr[n-1];
            return;
        }else if (arr[0]>=0 && arr[n-1]>=0){
            liquid1 = arr[0];
            liquid2 = arr[1];
            return;
        }

        int s=0;
        int e=n-1;
        liquid1 = arr[s];
        liquid2 = arr[e];
        sum = arr[s] + arr[e];

        while(s<e){
            int tmp=arr[s]+arr[e];
            if (tmp==0){
                liquid1 = arr[s];
                liquid2 = arr[e];
                sum = tmp;
                return;
            }
            if (isclose(tmp)){
                liquid1 = arr[s];
                liquid2 = arr[e];
                sum = tmp;
            }
            if (tmp>0){
                e--;
            }else{
                s++;
            }
        }
    }
    static boolean isclose(int t){
        if (Math.abs(sum)>Math.abs(t)){
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