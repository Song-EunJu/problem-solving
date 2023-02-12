/*
    ## 외판원 문제 : 비트마스크를 이용한 DP + DFS
    - 한 외판원이 한 도시를 출발해서 N개의 도시를 모두 거쳐, 다시 원래 도시로 돌아오는 순회 여행 경로 계획
    - 가장 적은 비용 들이는 여행 계획
    - 가장 적은 비용을 들이는 외판원 순회 여행 경로

    -> 모든 정점을 한번씩 방문하는 경우에 완탐으로 모든 경로를 조회하면, n!의 시간복잡도를 가짐
    결론 : 최단 순환 경로를 탐색해야 하는데
        1) N! 의 중복 경로를 제거해주는 DP 메모이제이션 기법 사용 (피보나치할 때 DP 사용하는 거 생각하기)
        2) 2^N의 모든 경로의 경우의 수를 표현해야 하므로 그만큼의 공간이 필요한데,
           매모리 사용량 줄이고, 성능 향상을 위해 2^N의 경우의 수를 N비트로 표현할 수 있는 비트마스킹 사용

    -> TSP 문제는 한 정점만 탐색해도 된다! 왜일까?
    - 한 정점에서 모든 정점을 순회하여, 다시 <<출발 정점>> 으로 돌아오는 최적 경로를 찾는 알고리즘이다.
    - 따라서 n개의 정점 중 어느 정점에서 탐색을 시작해도 같은 결과 반환!

    dp[cur][visit] = 현재 위치(cur) 에서의 도시 방문 현황이 visit 과 같을 때,
    나머지 도시들을 모두 방문하고 시작점으로 돌아갈 때 드는 최소 비용
*/
//public class baekjoon2098 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int cost[][] = new int[N][N];
//        StringTokenizer st;
//        for(int i=0;i<N;i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j=0;j<N;j++){
//               cost[i][j] = Integer.parseInt(st.nextToken());
//            }
//          }
//
//        // 비트마스킹 사용하기
//        for(int i=0;i<N;i++){
//            check | (1<<i);
//        }
//        arr = new int[n][n];
//        visited = new boolean[n][n];
//
//        for(int i=0;i<n;i++){
//            String s = br.readLine();
//            for(int j=0;j<n;j++){
//                arr[i][j] = s.charAt(j)-'0';
//            }
//        }
//    }
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2098 {
    static int n;
    static int[][] map;
    static int[][] dp;
    static final int INF = 11000000;	// MAX : 11,000,000
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        map = new int[n][n];
        // i : 현재 위치한 도시, j : 지금까지 방문한 도시 2진수
        dp = new int[n][(1 << n) - 1];	// ex) 1 << 5 = 100000(2) = 32 -> 우리의 최대값 : 11111(2) 이므로 1 빼기
        // dp = new int[n][31];

        // 1) Map 입력받아 대입하기
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int weight = Integer.valueOf(st.nextToken());
                map[i][j] = weight;
            }
        }

        // dp배열 초기화
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(dfs(0, 1));
    }

    // 어느 도시에서 시작하든지 최소비용은 같기 때문에 편안하게 0번도시부터 시작하자
    // @param: city - 현재 위치한 도시 인덱스, visitBitMask - 지금까지 방문한 도시 2진수
    // DFS 알고리즘 : 경우의 수를 구하는 경우, 경로의 특징을 저장하는 경우
    private static int dfs(int city, int visitBitmask) {

        if(visitBitmask == (1 << n) - 1) {	// 모든 도시를 방문했다면
            if(map[city][0] == 0) {	// 현위치에서 0번 도시로 가는 경로가 없는 경우
                return INF;
            }
            return map[city][0];	// 현재 도시에서 0번째 도시까지의 이동 거리
        }

        if(dp[city][visitBitmask] != INF) {	// dp 값이 존재하는경우
            return dp[city][visitBitmask];
        }

        for(int i = 0; i < n; i++) {	// 현재 도시(city)에서 각 i의 도시로 이동한 경우에 대해 DFS 수행
            // 1) 현재 방문 경로를 저장한 visitBitmask 랑 1<<i (i 도시로 이동한 경우에 1비트 마스킹한 거 합계가 0인 경우 == 한번도 그 도시를 방문하지 않은 경우
            // 2) 현재도시(city) 에서 i 의 도시로 이동하는 경로가 존재하는 경우
            if((visitBitmask & (1 << i)) == 0 && map[city][i] != 0) {
                /*
                    d[i][j] = 현재 있는 도시가 i이고 이미 방문한 도시들의 집합이 j일때,
                    방문하지 않은 나머지 도시들을 모두 방문한 뒤 출발 도시로 돌아올 때 드는 최소 비용
                */

                // 즉, 방문해야하는 도시(여기에 시작지점으로 돌아오는 것 포함) 들까지 가는 최소 비용
                dp[city][visitBitmask] = Math.min(dp[city][visitBitmask], dfs(i, visitBitmask | (1 << i)) + map[city][i]);
                // dfs(다음 도시, 다음 도시 방문했다고 가정) + 여기서 다음 도시까지의 거리 와 최소거리 비교
            }
        }
        return dp[city][visitBitmask];
    }
}