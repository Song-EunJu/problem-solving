import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 플로이드 와샬 : 모든 정점에서 모든 정점으로의 최단경로
 * - DP 에 근거
 * - <거쳐가는 정점>을 기준으로 최단거리를 구하는 것
 * - ex) 거쳐가는 정점 = 노드1
 *
 * X에서 Y로 가는 최소 비용 VS (X에서 노드1로 가는 비용 + 노드1에서 Y로 가는 비용)
 * 테이블 만듦 -> 현재까지 계산된 최소 비용
 */
public class baekjoon1956 {
    static int arr[][];
    static int min = Integer.MAX_VALUE;
    static int v,e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken()); // 정점
        e = Integer.parseInt(st.nextToken()); // 간선
        arr = new int[v+1][v+1]; // 인접행렬

        // 일단 다 무한대로 초기화
        for(int i=1;i<=v;i++){
            Arrays.fill(arr[i], 10000000);
        }

        // 인접행렬에 정점, 길이 값 채우기
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            arr[start][end] = dist;
        }

        for(int i=1;i<=v;i++) { // 정점으로 선택된 애들
            for(int j=1;j<=v;j++){ // 인접행렬 2차원 배열 돌면서 최단거리 계산
                for(int k=1;k<=v;k++){
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        for(int i=1;i<=v;i++){ // 사이클을 그려야하므로 (a,b) + (b,a) 경로를 더한 것 중 가장 작은 거 출력
            min = Math.min(min, arr[i][i]);
        }

        if(min < 10000000)
            System.out.println(min);
        else
            System.out.println("-1");
    }
}
