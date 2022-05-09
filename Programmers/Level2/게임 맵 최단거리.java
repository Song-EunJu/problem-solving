import java.util.*;
class Solution {
    // 상하좌우로 움직이기 위한 좌표값
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean visit[][];
    static int n,m;

    public int solution(int[][] maps) {
        int answer = 0;
        n=maps.length; // 5
        m=maps[0].length; // 5
        visit = new boolean[n][m];
        bfs(0,0,maps);
        return (maps[n-1][m-1]==1)?-1:maps[n-1][m-1];
    }

    public void bfs(int y, int x, int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});

        while(!queue.isEmpty()){
            int arr[] = queue.poll();
            int nowY=arr[0];
            int nowX=arr[1];

            for(int i=0;i<4;i++){
                int posY=nowY+dy[i];
                int posX=nowX+dx[i];

                if(posY>=0 && posY<n && posX>=0 && posX<m){
                    if(maps[posY][posX]==1 && visit[posY][posX]==false){ // 길이 뚫려있는데 방문하지 않은 경우
                        queue.add(new int[]{posY, posX});
                        maps[posY][posX]+=maps[nowY][nowX];
                        visit[posY][posX]=true;
                    }
                }
            }
        }
    }
}