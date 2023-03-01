package ssafy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MST_PrimTest2 {
    static class Vertex implements Comparable<Vertex>{
        int no, weight;

        public Vertex(int no, int weight) {
            super();
            this.no = no;
            this.weight = weight;
        }

        // 간선비용 오름차순으로 해야 최소힙으로 유지됨
        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int[][] adjMatrix = new int[V][V];
        boolean[] visited = new boolean[V]; // 신장트리에 포함여부
        int[] minEdge = new int[V];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        StringTokenizer st;
        for(int i=0;i<V;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<V;j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }

        int result = 0; // MST비용

        // 임의의 정점을 시작정점으로 사용하기 위한 처리
        minEdge[0] = 0;
        pq.offer(new Vertex(0, 0));

        int c=0;

        // 큐에 들어가는 애가 간선 수에 비례해서 들어가지 않고 v개 언저리에서 왓다갓다하는 경우에 이득
        // 그럼 Elog(E) -> log(V) 로 바귐
        // 완전그래프인형태인 간선 많은 경우 PQ가 더 별로일 수 있음

        while(!pq.isEmpty()) {
            // step1: 신장트리에 포함되지 않은 정점 중 minEdge 비용이 최소인 정점 찾기
            Vertex minVertex = pq.poll();

            // 신장트리에 포함된 경우 연산진행 X
            if(visited[minVertex.no])
                continue;

            // step2: 선택된 정점 신장트리에 추가
            result += minVertex.weight;
            visited[minVertex.no] = true;
            if(++c == V)
                break;

            // step3: 선택된 정점의 인접정점 (신장트리에 포함되지 않은 정점)의 간선비용의 최솟값 업데이트
            for(int i=0;i<V;i++) {
                if(!visited[i] && adjMatrix[minVertex.no][i]!=0
                        && minEdge[i] > adjMatrix[minVertex.no][i]){
                    minEdge[i] = adjMatrix[minVertex.no][i];
                    pq.offer(new Vertex(i, minEdge[i]));
                }
            }
        }
        System.out.println(c==V ? result : -1);
    }
}