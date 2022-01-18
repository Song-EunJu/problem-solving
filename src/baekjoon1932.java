import java.io.*;
import java.util.StringTokenizer;

public class baekjoon1932 {
    public static void main(String []args) throws IOException{
        // 선택된 수의 합이 최대가 되는 경로 구하기 / 대각선 왼, 오른쪽만 선택 가능
        // 동적계획법 - 모든 방법을 일일이 검토하여 최적의 해를 찾아내기
        // 그리디 알고리즘 - 그 순간에서의 최적의 해를 찾기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()){ // 토큰이 더 있는지 확인하고
                arr[i][j++]=Integer.parseInt(st.nextToken());
            }
        }

        /**
         *         7
         *       3   8
         *     8   1   0
         *   2   7   4   4
         * 4   5   2   6   5
            arr[1][0]+=arr[0][0];
            arr[1][1]+=arr[0][0];
            arr[2][0]+=arr[1][0];
            arr[2][1]+=Math.max(arr[1][0], arr[1][1]);
            arr[2][2]+=arr[1][1];

            arr[3][0]+=arr[2][0];
            arr[3][1]+=Math.max(arr[2][0], arr[2][1]);
            arr[3][2]+=Math.max(arr[2][0], arr[2][1]);
            arr[3][3]+=arr[2][2];
         */

        for(int k=1;k<=n-1;k++) {
            for (int j=0;j<=k;j++) {
                if(j==0) // 맨 왼쪽에 위치한 경우
                    arr[k][j]+=arr[k-1][j];
                else if(j==k) // 맨 오른쪽에 위치한 경우
                    arr[k][j]+=arr[k-1][j-1];
                else
                    arr[k][j]+=Math.max(arr[k-1][j-1], arr[k-1][j]);
            }
        }

        // 최댓값 찾기
        int max=0;
        for(int i=0;i<n;i++){
            if(arr[n-1][i]>max)
                max=arr[n-1][i];
        }
        System.out.print(max);
    }
}
