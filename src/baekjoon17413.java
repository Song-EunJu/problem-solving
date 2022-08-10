import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon17413 {
    public static StringBuilder sb = new StringBuilder();
    public static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if(str.contains("<")){ // 태그가 있는 문자열인 경우
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(ch=='<'){
                    sb.append(str, i, str.indexOf(">", i)+1);
                    i = str.indexOf(">", i);
                }
                else {
                    int end = str.indexOf("<", i);
                    String s = str.substring(i, (end==-1?str.length():end));
                    splitStr(s);
                    i = (end==-1?str.length():end)-1;
                }
            }
        }
        else{ // 태그가 없는 문자열인 경우
            splitStr(str);
        }
        System.out.println(sb);
    }

    public static void splitStr(String str){
        String[] s = str.split(" ");

        for(int i=0;i<s.length;i++) {
            for (int j=0;j<s[i].length();j++) {
                stack.push(s[i].charAt(j));
            }
            while(!stack.empty()){
                sb.append(stack.pop());
            }
            if(s.length>=2 && i!=s.length-1)
                sb.append(" ");
        }
    }
}
