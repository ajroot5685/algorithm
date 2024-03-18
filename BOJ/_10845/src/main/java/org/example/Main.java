package org.example;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    //정답은 sb에 append 를 사용하여 출력
    //만약 개행까지 출력하고 싶으면 append('\n')을 추가
    static StringBuilder sb = new StringBuilder();

    static int n;

    static Deque<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        input();
        System.out.println(sb.toString());
    }

    static void input(){
        n = scan.nextInt();
        for (int i=0;i<n;i++){
            solve(scan.nextLine());
        }
    }

    static void solve(String s){
        if (s.equals("front")){
            if (queue.isEmpty()){
                sb.append(-1);
                sb.append("\n");
            }else {
                sb.append(queue.peekFirst());
                sb.append("\n");
            }
        } else if (s.equals("back")) {
            if (queue.isEmpty()){
                sb.append(-1);
                sb.append("\n");
            }else {
                sb.append(queue.peekLast());
                sb.append("\n");
            }
        } else if (s.equals("size")) {
            sb.append(queue.size());
            sb.append("\n");
        } else if (s.equals("empty")) {
            if (queue.isEmpty()){
                sb.append(1);
                sb.append("\n");
            }else {
                sb.append(0);
                sb.append("\n");
            }
        } else if (s.equals("pop")) {
            if (queue.isEmpty()){
                sb.append(-1);
                sb.append("\n");
            }else {
                sb.append(queue.pollFirst());
                sb.append("\n");
            }
        } else{
            StringTokenizer st = new StringTokenizer(s);
            st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            queue.addLast(num);
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
