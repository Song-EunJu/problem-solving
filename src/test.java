//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
///*
//    경로의 길이 = 경로 상에 등장하는 정점의 개수
//    따라서 최장경로를 구하고, 그 경로 상에 등장하는 정점이 몇개인지 구하면 되는 문제!
//    문제 이해가 안돼서 계속 들여다봤네..
//
//*/
//public class test {
//    static boolean visited[];
//    static int arr[][];
//    static int N;
//    static int M;
//    static int max = Integer.MIN_VALUE;
//    static int cnt = 0;
//
//    public static void main(String[] args) throws IOException {
//        List<Integer> list = new ArrayList<>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//        int T = Integer.parseInt(br.readLine());
//        for(int i=0;i<T;i++){
//            st = new StringTokenizer(br.readLine());
//            N = Integer.parseInt(st.nextToken()); // 정점
//            M = Integer.parseInt(st.nextToken()); // 간선
//
//            arr = new int[N+1][N+1]; // 정점간의 인접행렬 구하기
//            for(int j=0;j<M;j++){
//                st = new StringTokenizer(br.readLine());
//                int x = Integer.parseInt(st.nextToken());
//                int y = Integer.parseInt(st.nextToken());
//                arr[x][y] = arr[y][x] = 1;
//            }
//
//            /**
//             * 가장 많은 정점을 지나는 최장 경로를 찾아야 하기 때문에
//             * 모든 정점의 FOR문을 돌면서 각 정점에서 가장 끝까지 찾아가는 DFS 를 모두 돌려봄
//             * 그리고 가장 큰 MAX 값을 출력
//             * DFS = 경로의 특징을 저장한다!!!!!!!!!!!!!!! (즉, 각 경로마다 지나는 정점개수의 상태를 저장해야 하므로)
//             * */
//            for(int j=1;j<=N;j++){ // 특정 정점에서 시작하는 dfs를 모두 구해봄
//                visited = new boolean[N+1];
//                dfs(j); // 1번노드에서 최장거리구하기 시작~
//                max = Math.max(max, cnt);
//                cnt = 0;
//            }
//            sb.append("#"+(i+1)+" "+max+"\n");
//            max = Integer.MIN_VALUE;
//        }
//        System.out.println(sb);
//    }
//}
