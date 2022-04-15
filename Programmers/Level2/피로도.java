import java.util.*;
class Solution {
    static boolean visit[];
    static int answer=0;
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length]; // 방문 여부
        dfs(dungeons, k, 0);
        return answer;
    }

    void dfs(int [][] dungeons, int k, int depth){
        int temp=k;
        for(int i=0;i<dungeons.length;i++){
            if(dungeons[i][0]<=temp && visit[i]==false){
                visit[i]=true;
                temp-=dungeons[i][1];
                dfs(dungeons, temp, depth+1);
                visit[i]=false;
                temp+=dungeons[i][1];
            }
        }
        answer = Math.max(answer, depth); // 가장 깊은 depth 인 경우가 답이 되므로
    }
}