import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1259 {
    public static void main(String[] args) throws IOException {
        // 홀수, 짝수 나누어서 비교
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(Integer.valueOf(str) == 0)
                break;

            int start = 0;
            int end = str.length()-1;
            boolean flag = true;
            while(start < end){
                if (str.charAt(start) != str.charAt(end)) {
                    sb.append("no\n");
                    flag = false;
                    break;
                }
                start++;
                end--;
            }
            if(flag)
                sb.append("yes\n");
        }
        System.out.println(sb);
    }
}
