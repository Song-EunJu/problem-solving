// 그림에 몇개 영역이 있고, 가장 큰 영역의 넓이는 얼마인지
// 원소 값이 0이면 색칠하지 않는 영역
// 영역 : 상하좌우로 연결된 같은 색상의 공간
// 고냥 단순한 BFS 문제
import java.util.*;
class Node {
    int y;
    int x;

    Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}
class Solution {
    static boolean visited[][];
    static int dx[] = new int[]{0, 0, 1, -1};
    static int dy[] = new int[]{1, -1, 0, 0};
    static int M;
    static int N;
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        int max = Integer.MIN_VALUE;
        M = m;
        N = n;
        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]!=0 && visited[i][j]==false){ // 새로운 영역이 시작되는 곳이므로 cnt 카운트
                    cnt++;
                    int area = bfs(picture[i][j], i, j, picture);
                    max = Math.max(area, max); // 가장큰 영역 계산하기
                }
            }
        }
        return new int[]{cnt, max};
    }

    public int bfs(int num, int y, int x, int[][] picture){
        int area=0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x));
        visited[y][x] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            int nowY = node.y;
            int nowX = node.x;

            for(int i=0;i<4;i++){ // 상하좌우를 돌면서, 해당 숫자와 같은 수를 주변에서 다 찾는다
                int posY = nowY+dy[i];
                int posX = nowX+dx[i];
                if((posY>=0 && posY<M) && (posX>=0 && posX<N) && picture[posY][posX] == num &&
                   visited[posY][posX] == false){
                    q.add(new Node(posY, posX));
                    visited[posY][posX] = true;
                }
            }
            area++;
        }
        return area;
    }
}