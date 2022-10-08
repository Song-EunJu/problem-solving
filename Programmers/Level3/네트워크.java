/**
 * 처음에 하나 노드 물고, 줄줄이 소세지로 딸린거 다 계산하는 DFS라고 생각
 * 근데 뭔가 그룹단위로 묶어서 영역을 구분하듯이 구하는 BFS로도 가능할 거라 생각
 * -> 둘다 가능 ~
 * */
import java.util.*;
class Solution {
    static boolean visit[];

    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        int cnt=0;

        // (1,2,3) (4,5) 요렇게 완전 분리되어 있는 경우를 대비해서 반복문을 돌면서 접근하지 않은 노드마다 bfs 돌아줌
        for(int i=0;i<computers.length;i++){
            if(visit[i]==false){
                bfs(i, computers);
                cnt++;
            }
        }
        return cnt;
    }

    public void bfs(int num, int[][] computers){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visit[num] = true;

        while(!q.isEmpty()){
            int n = q.poll();
            visit[n] = true;

            for(int i=0;i<computers.length;i++){
                if(n!=i && computers[n][i]==1 && visit[i]==false){
                    q.add(i);
                }
            }
        }
    }
}

import java.util.*;
class Solution {
    static boolean visit[];
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        int cnt=0;
        for(int i=0;i<computers.length;i++){
            if(visit[i]==false){
                dfs(i, computers);
                cnt++;
            }
        }
        return cnt;
    }

    public void dfs(int n, int[][] computers){
        visit[n]=true;
        for(int i=0;i<computers.length;i++){
            if(n!=i && computers[n][i]==1 && visit[i]==false){
                dfs(i, computers);
            }
        }
    }
}