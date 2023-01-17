import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 설명 : 오른쪽무게 총합 <= 왼쪽 무게 총합
/**
 * dfs 까지는 생각했는데, (왼, 오) 배열을 어떻게 나눠야 할 지를 모르겠었음
 * 그리고 어떻게 순서를 고려해야 할 지를 모르겠음
 *
 * 1) left 에 다 올리는 경우
 * 2) right 에 올려도 left 보다는 작은 경우
 * 각 무게를 방문처리하고 위의 두 경우의 left, right sum 을 계산하여 left >= sum 인 경우만 카운트
 * */
public class test2 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            cnt = 0;
            int n = Integer.parseInt(br.readLine());
            int[] weight = new int[n];
            boolean[] visit = new boolean[n];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                weight[j] = Integer.parseInt(st.nextToken());
            dfs(n, 0, 0,0, weight, visit);
            sb.append("#"+(i+1)+" "+cnt+"\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int n, int num, int left, int right, int[] weight, boolean[] visit){
        if(num == n){
            if(left >= right)
                cnt++;
            return;
        }

        for(int i=0;i<n;i++){
            if(visit[i] == false){
                visit[i] = true;
                dfs(n, num+1, left+weight[i], right, weight, visit);
                if(left >= right+weight[i])  // 오른쪽에 올려도 왼쪽이 큰 경우
                    dfs(n, num+1, left, right+weight[i], weight, visit);
                visit[i] = false;
            }
        }
    }
}

