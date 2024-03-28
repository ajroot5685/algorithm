package org.example;


import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    //정답은 sb에 append 를 사용하여 출력
    //만약 개행까지 출력하고 싶으면 append('\n')을 추가
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static LinkedList<Integer> deque = new LinkedList<>();
    static int result=0;

    public static void main(String[] args) {
        input();
        System.out.println(result);
    }
    static void input(){
        n = Integer.parseInt(scan.next());
        m = Integer.parseInt(scan.next());

        for (int i=1;i<=n;i++){
            deque.offerLast(i);
        }

        for (int i=0;i<m;i++){
            solve(Integer.parseInt(scan.next()));
        }
    }
    static void solve(int num){
        int now = deque.indexOf(num);
        int mid = deque.size()/2;
        if (now == 0){
            poll();
        } else if (now<=mid) {
            left(now);
        }else{
            right(deque.size()-now);
        }
    }
    static void poll(){
        deque.pollFirst();
    }
    static void left(int it){
        for (int i=0;i<it;i++){
            deque.offerLast(deque.pollFirst());
            result++;
        }
        poll();
    }
    static void right(int it){
        for (int i=0;i<it;i++){
            deque.offerFirst(deque.pollLast());
            result++;
        }
        poll();
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
