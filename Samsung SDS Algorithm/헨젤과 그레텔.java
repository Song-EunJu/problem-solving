// 테스트 코드는 모두 맞지만, 시간초과 나는 코드
/*
[문제 요약]
- 집으로부터 최소 이동으로 아이들을 찾기 위해 필요한 빵 부스러기만 남김
- 부모님은 (1,1)에서 출발, 상하좌우에 빵부스러기가 있는 격자 (빵부스러기가 있었던 자리)로만 이동
- 아이들을 찾기 위한 최소 이동횟수가 2개이상이면, 까마귀 둥지로부터 빵 부스러기들의 거리 합이 최소가 되도록

- 구해야 하는 것 : 아이들을 찾는 최소 이동 횟수 / 까마귀가 먹을 수 있는 빵 부스러기 거리 합 최소 값
*/

/*
[생각의 흐름 정리]
최단거리는 bfs 여야될 것 같은데, dfs로 경우의 수를 구해야할 것 같다.
-> 2가지, 경우의 수를 구하고
만약 bfs 로 최단거리를 구한다면, 현재까지 지점의 dist 를 함께 노드에 저장해두어야 할 것 같다.
-> 경로 번호도 지정을 해둬야 하나,, ?
-> 근데 경로가 겹치는 경우도 있으니 안될 것 같다.

// 우선 과자집까지 가는 최단경로 n 개를 구해야 함
// n개의 경로 횟수가 동일하다면 지나간 길 말고 남은 과자길이 둥지랑의 차이 값을 구해야 함
// 가장 작은 최소 값이랑 최소 이동 횟수
*/

import java.util.*;
import java.io.*;
public class Main {
    static int arr[][];
    static boolean visited[][];
    static int dx[]= {0, 0, 1, -1};
    static int dy[]= {1, -1, 0, 0};
    static int distMin; // 아이들을 찾는 최소 이동 횟수
    static int breadMin; // 까마귀가 먹을 수 있는 빵 부스러기 거리 최소 값
    static int N,M,R,C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 수행횟수

        for(int test=0;test<T;test++){
            breadMin = Integer.MAX_VALUE;
            distMin = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N+1][M+1];
            visited = new boolean[N+1][M+1];

            // 까마귀 둥지 좌표
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            for(int i=1;i<=N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<=M;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited[1][1] = true;
            dfs(1, 1);
            sb.append("#"+(test+1)+" "+(distMin-1)+" "+breadMin+"\n");
        }
        System.out.print(sb);
    }

    // 좌표 값이 배열 범위를 벗어나지 않는지 확인
    public static boolean isIn(int posY, int posX){
        if(posY>=1 && posY<=N && posX>=1 && posX<=M)
            return true;
        return false;
    }

    // 최솟값보다 작은 경우에만 계속 연산
    public static boolean promisingMinDist(int posY, int posX){
        if(arr[posY][posX] < distMin)
            return true;
        return false;
    }

    public static void dfs(int y, int x){
        if(y == N && x == M) {
            int sum = 0;
            // 빵가루랑 둥지간의 최솟값 구하기
            for(int i=1;i<=N;i++){
                for(int j=1;j<=M;j++){
                    if(!(i==1 && j==1) && arr[i][j] == 1){ // 첫번째 좌표가 아닌데 값이 1인 경우
                        sum += Math.abs(i-R) + Math.abs(j-C);
                    }
                }
            }

            // 빵 부스러기 거리 최소합과 부모님이 아이 찾는 거리 최소 값 구하기
            if(arr[y][x] < distMin)
                breadMin = sum;
            else if(arr[y][x] == distMin)
                breadMin = Math.min(sum, breadMin);

            distMin = Math.min(arr[y][x], distMin);
        }

        for(int i=0;i<4;i++){
            int posY = y + dy[i];
            int posX = x + dx[i];

            if(isIn(posY, posX) && arr[posY][posX] == 1 &&
                    visited[posY][posX] == false && promisingMinDist(posY, posX)){
                visited[posY][posX] = true;
                arr[posY][posX] += arr[y][x]; // 거리의 합을 전에 방문한 장소 + 1로 계산
                dfs(posY, posX);
                arr[posY][posX] -= arr[y][x];
                visited[posY][posX] = false;
            }
        }
    }
}