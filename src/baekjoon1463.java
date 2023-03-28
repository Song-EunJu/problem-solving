import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * if,else if 로 묶으면 안됨. 
 * 모든 경우의 수에서 가장 작은 경우를 구해야 하니까
 * if 문으로 따로 따로 분기처리해서 dp 값에 있는 가장 작은 값 구해야 함
 * */
public class baekjoon1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N+1];

        for(int i=2;i<=N;i++){
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;
            
            if(i%3==0) 
                a = Math.min(dp[i/3], dp[i-1])+1;
            
            if(i%2==0)
                b = Math.min(dp[i/2], dp[i-1])+1;

            if(i%3!=0 && i%2!=0)
                c = dp[i-1]+1;

            dp[i] = Math.min(Math.min(a,b),c);
        }
        System.out.println(dp[N]);
    }
}
