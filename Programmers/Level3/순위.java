// 정확하게 순위를 매길 수 있는 선수의 수를 구하라
// 이게 어떻게 플로이드 워셜알고리즘 일까.
/*
플로이드 워셜=모든 노드 간의 최단경로 계산할 때 사용
-> 모든 노드별로 '특정 노드'를 거쳐 '다른 모든 노드' 로 가는 최단 경로를 저장하려고, 2차원 리스트 활용

그러면 (1>2) (2>5) 인 경우 무조건 (1>5) 이니까 2라는 사람을 거쳐서 다른 모든 사람들로부터의 승패여부를 찾을 수 있겠군
-> 한명씩을 거쳐서 나의 승패여부를 찾는 것
*/
import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int rank[][] = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(rank[i], 0);
        }

        // 일단 가진 걸로 승패 결과를 배열에 채움
        for(int i=0;i<results.length;i++){
            int win = results[i][0];
            int lose = results[i][1];
            rank[win][lose] = 1; // 이긴 경우
            rank[lose][win] = -1; // 진 경우
        }

        for(int k=1;k<=n;k++){ // 중간노드를 제일 바깥에 둠 -> 하나 제대로 부시자 이건
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(rank[i][k]==1 && rank[k][j]==1){
                        rank[i][j]=1; // i가 k이겼고, k가 j이겼으니까 i는 당연히 j를 이김
                        rank[j][i]=-1; // 반대로 j는 i한테 당연히 짐
                    }

                    if(rank[i][k]==-1 && rank[k][j]==-1){
                        rank[i][j]=-1;
                        rank[j][i]=1;
                    }
                }
            }
        }

        for(int i=1;i<=n;i++){
            int cnt=0;
            for(int j=1;j<=n;j++){
                if(rank[i][j]!=0){
                    cnt++;
                }
            }
            if(cnt==n-1)
                answer++;
        }

        return answer;
    }
}
/*
        int winner[] = new int[n+1];
        int loser[] = new int[n+1];

        for(int i=0;i<n;i++){
            winner[results[i][0]]++;
            loser[results[i][1]]++;
        }

        for(int i=1;i<=n;i++){
            if(winner[i]+loser[i] == n-1){
                answer++;
                for(int j=0;j<n;j++){
                    if(results[j][0] == i)
                        answer++;
                }
            }
        }
*/