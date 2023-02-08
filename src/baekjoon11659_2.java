import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  구간합을 매번 for문을 돌면서 구하기는 좀...
 *  -> N, M 이 10만 까지니까
 *  -> dp 로 합을 저장해놓고 dp[j]-dp[i] 하면 되지 않을까?
 */
// 전체 시간 복잡도 : O(N+M)
public class baekjoon11659_2 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int dp[] = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) { // O(N)
            dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++) { // O(M)
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(dp[m]-dp[n-1]+"\n");

        }
        System.out.println(sb);
    }
}