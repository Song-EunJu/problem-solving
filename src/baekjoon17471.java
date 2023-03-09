import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon17471 {
    static int N;
    static boolean visit[];
    static int population[];
    static List<Integer>[] map;

    public static void main(String[] args) throws IOException {
        // 구역을 두 개의 선거구로 나눠야 하고,
        // 각 구역은 두 선거구 중 하나에 포함되어야 한다.
        // 선거구는 구역을 적어도 하나 포함해야 하고, 한 선거구에 포함되어 있는 구역은 모두 연결되어 있어야 한다.
        // 구역 A에서 인접한 구역을 통해서 구역 B로 갈 수 있을 때, 두 구역은 연결되어 있다고 한다.
        // 중간에 통하는 인접한 구역은 0개 이상이어야 하고, 모두 같은 선거구에 포함된 구역이어야 한다.

        // 두 선거구에 포함된 인구차이를 최소로 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 구역 개수
        visit = new boolean[N+1];
        population = new int[N+1]; // 구역의 인구
        map = new ArrayList[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            population[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<=N;i++){
            map[i] = new ArrayList<>();
        }

        // 인접리스트 생성
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int j=0;j<m;j++){
                map[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        divideArea(0);
        // 구역을 2개로 나누기
        // 그 구역 2개가 다 연결되어있는지 체크
        // 연결되어 있다면 인구의 합이 최소
    }

    // 적어도 1개는 포함하도록
    private static void divideArea(int cnt) {
        if(cnt == N){
            // 다 true 이거나 다 false 인 경우는 제외 해야 함.

            System.out.print("첫번째 집합 : ");
            for(int i=0;i<N;i++){
                if(visit[i] == true){
                    System.out.print((i+1)+" ");
                }
            }
            System.out.println();
            System.out.print("두번째 집합 : ");
            for(int i=0;i<N;i++){
                if(visit[i] == false){
                    System.out.print((i+1)+" ");
                }
            }
            System.out.println();
            return;
        }
        visit[cnt] = true;
        divideArea(cnt+1);
        visit[cnt] = false;
        divideArea(cnt+1);
    }
}
