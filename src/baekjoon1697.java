import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [사고의 흐름]
 * 1초 뒤에 (x-1) (x+1) (2x) 이걸 다해봐야 하나?
 *  if(i == K) {
 *             cnt++;
 *             min = Math.min(min, cnt);
 *         }
 *         move(N-1);
 *         move(N+1);
 *         move(2*N);
 *  이런식으로 dfs 코드를 작성했었는데, 최단 경로를 찾기 위해서는 특정 지점에서 갈 수 있는 방향을 모두 큐에 넣고
 *  하나씩 꺼내면서 방문처리하고 몇 초 걸리는 지 저장하는 bfs를 썼어야 함
 * */
public class baekjoon1697 {
    static int N,K;
    static int visit[] = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(visit[K]);
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        while(!q.isEmpty()){
            int num = q.poll();

            if(num == K)
                break;

            if(num-1 >= 0 && visit[num-1] == 0){
                visit[num-1] = visit[num] + 1;
                q.add(num-1);
            }

            if(num+1 <= 100000 && visit[num+1] == 0){
                visit[num+1] = visit[num] + 1;
                q.add(num+1);
            }

            if(num*2 <= 100000 && visit[num*2] == 0){
                visit[num*2] = visit[num] + 1;
                q.add(num*2);
            }
        }
    }
}
