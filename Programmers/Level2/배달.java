// visit 배열이 필요한 이유 -> 내가 방문한 정점이 어디인지 확인하기 위해서
// dist 배열이 필요한 이유 -> 최단 거리를 저장하기 위해서
import java.util.*;
class Solution {
    static List<Node>[] list;
    static int dist[];
    static boolean visited[];

    public int solution(int N, int[][] road, int K) {
        list = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];

        // 거리배열을 최댓값으로 채움
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];

            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        dijkstra(1);

        int cnt=0;
        for(int i=1;i<N+1;i++){
            if(dist[i] <= K)
                cnt++;
        }
        return cnt;
    }

    static void dijkstra(int start){
        Queue<Node> q = new PriorityQueue<>();

        // 시작노드 값 초기화, 시작점~시작점의 거리는 0
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Node node = q.poll();
            int to = node.to;

            // 방문한 노드라면 아래 과정 진행X
            if(visited[to])
                continue;
            else
                visited[to] = true;

            /**
             1 - (2,1) (4,2)
             2 - (1,1) (3,3) (5,2)
             아래와 같은 예시인 경우, list[1]의 인접 노드들로 반복문을 돈다
             */
            for(Node next: list[to]){
                int nextTo = next.to; // 1번과 연결된 n번 노드
                int nextWeight = next.weight; // 1~n번 노드까지 향하는 거리
                int cost = dist[to] + nextWeight; // 현재 1번노드까지의 최단거리 + 1~n 번 노드까지 거리

                // n번노드까지의 최단거리 >= 현재 1번노드까지의 최단거리+1~n번 노드까지의 거리라면
                // == 즉, 한 다리 거쳐 가는 경우가 최단거리라면
                if(cost <= dist[nextTo]) {
                    dist[nextTo] = cost;
                    q.add(new Node(nextTo, dist[nextTo])); // 그 한다리 거치는 노드를 큐에 넣어줘야 함
                }
            }
        }
    }
}

// 목적지와 거리를 담기 위한 클래스 선언
class Node implements Comparable<Node>{
    int to;
    int weight;

    Node(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

    // 가중치를 기준으로 Comparable을 선언하여 우선순위 큐 판단 기준 제공
    @Override
    public int compareTo(Node node){
        return this.weight-node.weight;
    }
}
