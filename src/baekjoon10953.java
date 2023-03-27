import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String[] str = br.readLine().split(",");
            System.out.println(str[0].charAt(0)-'0' + str[1].charAt(0)-'0');
        }
    }
}
