import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1956 {
    static int arr[][];
    static int visit[];
    static int length;
    static int min = Integer.MAX_VALUE;
    static int v,e;
    static int firstStart;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        visit = new int[v+1]; // 정점 방문 여부
        arr = new int[v+1][v+1]; // 인접행렬

        // 인접행렬에 정점, 길이 값 채우기
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            arr[start][end] = dist;
        }

        for(int i=1;i<=v;i++){
            firstStart = i;
            cnt++;
            dfs(i);
        }
        if(min == Integer.MAX_VALUE)
            System.out.println("-1");
        System.out.println(min);
    }

    // (1,2) (2,1) -> 6
    public static void dfs(int start) {
        // 시작지점이랑 돌아온 지점이 같은 경우
        if(firstStart == start && cnt==0){
            if(min > length)
                min = length;
            return;
        }

        // 불가능한 경우 -1 출력
        int i = start;

        for(int j=1;j<=v;j++) {
            if(visit[start]==1) {// 이미 방문했던 애면

            }

            if (arr[i][j] != 0) { // 0이 아닌 경우에 더하고
                length += arr[i][j]; // length=1
                start = j; // start = 2
                visit[start]=1;
                dfs(start); // dfs(2)
                cnt=0;
                length -= arr[i][j];
            }
        }
    }
}

/*
- 도로 길이의 합이 가장 작은 사이클 찾기
- 최단거리 : 원형큐
1. 0과 -1이 아닌 지점부터 포문 돌면서 -1 과 0이 아닌
(2.n) 을 21 22 23 각각 큐에 넣음
- n자리가 시작점이랑 동일하면 저장
* */