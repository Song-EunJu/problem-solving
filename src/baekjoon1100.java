import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1100 {
    public static void main(String[] args) throws IOException {
        // i가 짝수일 때는 j가 짝수인 경우가 흰색말
        // i가 홀수일 때는 j가 홀수인 경우가 흰색말
        // 흰색 말 -> F

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        for(int i=0;i<8;i++){
            String str = br.readLine();
            for(int j=0;j<8;j++){
                if(i%2==0 && j%2==0 && str.charAt(j)=='F')
                    result++;
                else if(i%2==1 && j%2==1 && str.charAt(j) == 'F')
                    result++;
            }
        }
        System.out.println(result);
    }
}
