import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 구역을 2개로 나누기 -> 깔끔하게 나누는 방법을 알고 싶음.
// 그 구역 2개가 다 연결되어있는지 체크 -> bfs
// 연결되어 있다면 인구의 합이 최소
public class baekjoon17471 {
    static int N;
    static boolean visit[];
    static int population[];
    static List<Integer>[] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
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
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void divideArea(int cnt) {
        if(cnt == N){
            /**
             * [부분집합을 2개로 나누기]
             * 1. boolean형 visit 배열 T/F 로 나눠서 리스트에 넣기
             * 2. int형 배열에 1,2 와 같은 데이터로 구분하기
             * ex) area[k] = 1;
             *     dfs(k + 1);
             *     area[k] = 2;
             *     dfs(k + 1);
             */
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();

            int populationA = 0;
            int populationB = 0;
            for(int i=0;i<N;i++){
                if(visit[i]) {
                    listA.add(i + 1);
                    populationA += population[i+1];
                }
                else {
                    listB.add(i + 1);
                    populationB += population[i+1];
                }
            }

            // 다 true 이거나 다 false 인 경우는 제외 해야 함.
            if(listA.size() == 0 || listB.size() == 0)
                return;

            if(check(listA) && check(listB)) // 2개가 다 연결되어 있다면
                min = Math.min(min, Math.abs(populationA-populationB));

            return;
        }
        visit[cnt] = true;
        divideArea(cnt+1);
        visit[cnt] = false;
        divideArea(cnt+1);
    }
    /**
     * 뽑은 좌표들이 모두 연결되어 있는지를 어떻게 BFS 로 어떻게 확인하는지 감이 안잡혔음
     * */
    private static boolean check(List<Integer> list) {
        boolean visitInCheck[] = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(list.get(0));
        visitInCheck[list.get(0)] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            /** A 리스트에 속한 요소를 하나씩 꺼내고
             * 원래 전체 구역 내에서 해당 요소랑 인접한 노드들을 꺼낸다
             * 이 때, 인접한 노드가 A 리스트에 속했는데 방문하지 않은 경우에만 큐에 다시 넣는다
             * **/
            for(int num : map[node]){
                if(list.contains(num) && visitInCheck[num] == false){
                    q.add(num);
                    visitInCheck[num] = true;
                }
            }
            cnt++;
        }
        // 큐에 넣은 갯수가 A 리스트의 크기랑 동일하면 모두 연결된 그래프인 것
        if(cnt == list.size())
            return true;
        return false;
    }
}
