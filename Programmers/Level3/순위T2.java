import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n+1][n+1];

        // 1. 연산할 배열 무한대로 초기화
        for(int i=0;i<=n;i++)
            Arrays.fill(arr[i], Integer.MAX_VALUE);

        // 2. results 배열을 돌면서 results 배열에 1, 0 채우기
        for(int i=0;i<results.length;i++){
            int a = results[i][0];
            int b = results[i][1];
            arr[a][b] = 1; // 이긴 경우 1
            arr[b][a] = 0; // 진 경우 0
        }

        // 3. 삼중 for문을 돌면서 이기고 진 경우에 대한 판단
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(arr[i][k]+arr[k][j] == 2){
                        arr[i][j] = 1;
                        arr[j][i] = 0;
                    }
                }
            }
        }

        for(int i=1;i<=n;i++){
            int cnt = 0;
            for(int j=1;j<=n;j++){
                if(arr[i][j] == Integer.MAX_VALUE)
                    cnt++;
            }
            if(cnt == 1) // 자기자신인 경우만 MAX_VALUE 인 경우
                answer++;
        }
        return answer;
    }
}