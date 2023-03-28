import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * top-down : 재귀 -> 특정 값을 주고 구해라  ex) f(8)을 구해라
 *            재귀 + 메모이제이션 -> DP
 *            가장 큰 문제에서 작은 문제를 쪼개가면서 하니까 분할정복
 * bottom-up : 반복문 -> 전체를 다 돌면서 최소, 최대 값을 구해라
 * */
public class baekjoon1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3]; // dp 배열
        int[][] array = new int[N][3]; // 원본 배열

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++)
                array[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for(int i=0;i<N-1;i++){
            for(int j=0;j<3;j++){
                int num = array[i][j];
                for(int k=0;k<3;k++) {
                    if (j != k) {
                        dp[i + 1][k] = Math.min(dp[i+1][k], num + array[i + 1][k]);
                    }
                }
            }
            for(int k=0;k<3;k++){
                array[i+1][k] = dp[i+1][k];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            if(dp[N-1][i] < min)
                min = dp[N-1][i];
        }
        System.out.println(min);
    }
}
