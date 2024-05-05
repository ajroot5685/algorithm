import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static String str;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void solve() {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && priority(stack.peekFirst()) >= priority(c)) {
                    sb.append(stack.pollFirst());
                }
                stack.offerFirst(c);
            } else if (c == '(') {
                stack.offerFirst(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peekFirst() != '(') {
                    sb.append(stack.pollFirst());
                }
                stack.pollFirst();
            } else {
                sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        System.out.println(sb);
    }

    public static int priority(char operator){

        if(operator=='(' || operator==')'){
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }

    static void input() {
        str = scan.next();
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
    }
}
