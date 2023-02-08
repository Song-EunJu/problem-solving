//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
///*
//    ## 외판원 문제 : 비트마스크를 이용한 DP + DFS
//    - 한 외판원이 한 도시를 출발해서 N개의 도시를 모두 거쳐, 다시 원래 도시로 돌아오는 순회 여행 경로 계획
//    - 가장 적은 비용 들이는 여행 계획
//    - 가장 적은 비용을 들이는 외판원 순회 여행 경로
//
//    -> 모든 정점을 한번씩 방문하는 경우에 완탐으로 모든 경로를 조회하면, n!의 시간복잡도를 가짐
//    결론 : 최단 순환 경로를 탐색해야 하는데
//        1) N! 의 중복 경로를 제거해주는 DP 메모이제이션 기법 사용 (피보나치할 때 DP 사용하는 거 생각하기)
//        2) 2^N의 모든 경로의 경우의 수를 표현해야 하므로 그만큼의 공간이 필요한데,
//           매모리 사용량 줄이고, 성능 향상을 위해 2^N의 경우의 수를 N비트로 표현할 수 있는 비트마스킹 사용
//
//    -> TSP 문제는 한 정점만 탐색해도 된다! 왜일까?
//    - 한 정점에서 모든 정점을 순회하여, 다시 <<출발 정점>> 으로 돌아오는 최적 경로를 찾는 알고리즘이다.
//    - 따라서 n개의 정점 중 어느 정점에서 탐색을 시작해도 같은 결과 반환!
//
//    dp[cur][visit] = 현재 위치(cur) 에서의 도시 방문 현황이 visit 과 같을 때,
//    나머지 도시들을 모두 방문하고 시작점으로 돌아갈 때 드는 최소 비용
//
//
//*/
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
