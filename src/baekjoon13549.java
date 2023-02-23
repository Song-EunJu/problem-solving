import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 반례 : 1 2 -> 1 이 나오던 상황,
 * 1에서 2배하는 경우면 0이 나와야 하니까 (num+1, num-1, num*2) 이렇게 넣었던 큐에 넣는 순서를 바꿔 주었음
 * 그래도 1이 나오던 상황. 왜냐면 num+1 함수 부분에서 visit[2] = visit[1]+1 로 다시 1로 업뎃시켜주는 코드가 있음
 *
 * if(num+1 <= 100000 && visit[num+1] == 0){
 *                 visit[num+1] = visit[num] + 1;
 *                 q.add(num+1);
 *             }
 * 그래서 num*2 하는 경우에는 visit 체크에서 +1 가 아니라 +0 이어서 0으로 visit 체크를 하면, 방문 안한걸로 애가 착각함
 * 그래서 방문 배열을 다 -1 로 초기화 해주는 코드 추가함
 * */
public class baekjoon13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] visit = new int[100001];
        Arrays.fill(visit, -1);
        bfs(N, K, visit);
        System.out.println(visit[K]);
    }

    public static void bfs(int N, int K, int[] visit){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visit[N] = 0;

        while(!q.isEmpty()){
            int num = q.poll();

            if(num == K)
                break;

            if(num*2 <= 100000 && visit[num*2] == -1){
                visit[num*2] = visit[num];
                q.add(num*2);
            }

            if(num-1 >= 0 && visit[num-1] == -1){
                visit[num-1] = visit[num] + 1;
                q.add(num-1);
            }

            if(num+1 <= 100000 && visit[num+1] == -1) {
                visit[num + 1] = visit[num] + 1;
                q.add(num + 1);
            }
        }
    }
}
