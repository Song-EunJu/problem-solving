import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon18429 {
    static int N;
    static int K;
    static int arr[];
    static boolean visited[];
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 운동 키트 개수
        K = Integer.parseInt(st.nextToken()); // 매일 감소하는 중량
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 500); // depth, start
        System.out.println(cnt);
    }

    public static void backtracking(int depth, int sum){
        if(depth == N) {
            cnt++;
        }

        for(int i=0;i<N;i++){
            if(visited[i] == false){
                if(sum-K+arr[i] >= 500){
                    /**
                        요 부분에서 sum = sum-K+arr[i] 문장이 있었는데,
                        이 때 sum값을 바꿔버리면 visited[i] = false 로 두고
                        다시 방문처리를 안한 경우에도 해당 값으로 계산된 값이 남아있는 것이므로 문제가 됨
                     */
                    visited[i] = true;
                    backtracking(depth+1, sum-K+arr[i]);
                    visited[i] = false;
                }
            }
        }
    }
}
