package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class jungol1015 {
    static Stack<String> forward = new Stack<>();
    static Stack<String> backward = new Stack<>();
    static String nowUrl = "http://www.acm.org/";
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String url = "";

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("VISIT"))
                url = st.nextToken();

            if(op.equals("QUIT"))
                break;

            switch(op){
                case "BACK":
                    back();
                    break;
                case "FORWARD":
                    forward();
                    break;
                case "VISIT":
                    visit(url);
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void back() {
        if(backward.isEmpty())
            sb.append("Ignored\n");
        else {
            forward.push(nowUrl);
            nowUrl = backward.pop();
            sb.append(nowUrl+"\n");
        }
    }

    public static void forward() {
        if(forward.isEmpty())
            sb.append("Ignored\n");
        else {
            backward.add(nowUrl);
            nowUrl = forward.pop();
            sb.append(nowUrl+"\n");
        }
    }

    public static void visit(String inputUrl) {
        backward.add(nowUrl);
        nowUrl = inputUrl;
        forward.clear();
        sb.append(nowUrl+"\n");
    }
}