import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DP = 재귀 + 메모이제이션
 * */
public class baekjoon9184 {
    static int dp[][][] = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if((a==-1 && b==-1 && c==-1))
                break;
            sb.append(String.format("w(%d, %d, %d) = %d",a,b,c,res(a,b,c))+"\n");
        }
        System.out.println(sb);
    }

    public static int res(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;
        else if((a>=0 && a<=20) && (b>=0 && b<=20) && (c>=0 && c<=20) && dp[a][b][c]!=0){
            return dp[a][b][c];
        }
        else if (a > 20 || b > 20 || c > 20)
            return dp[20][20][20] = res(20,20,20);
        else if (a < b && b < c)
            return dp[a][b][c] = res(a,b,c-1) + res(a,b-1,c-1) - res(a,b-1,c);
        else
            return dp[a][b][c] = res(a-1,b,c) + res(a-1, b-1, c) + res(a-1, b, c-1) - res(a-1, b-1, c-1);
    }
}