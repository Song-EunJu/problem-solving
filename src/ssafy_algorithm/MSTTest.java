package ssafy_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class MSTTest {
    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(MSTTest.Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int V,E;
    // V - 정점 / E - 간선
    static Edge[] edgeList;
    static int[] parents;

    static void makeSet() {
        parents = new int[V];
        for(int i=0;i<V;i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if(a == parents[a])
            return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot)
            return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        edgeList = new Edge[E];

        for(int i=0;i<E;i++) {
            edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        // 1. 모든 정점을 각각 단위 서로소 집합으로 만듦
        makeSet();

        // 2. 간선 오름차순 정렬
        Arrays.sort(edgeList);

        // 3. 가중치가 낮은 간선들부터 가중치를 더해가면서 정점 개수가 V-1개가 될 때까지 반복
        int result = 0; // 신장트리 비용
        int count = 0; // 신장트리를 만들기 위한 간선의 개수

        for(Edge edge: edgeList) { // 1개의 간선 정보가 담고 있는 것 = 합쳐야 할 집합의 구성원인 정점 2개
            if(union(edge.from, edge.to)) {
                result += edge.weight;
                if(++count == V-1) { // 누적한 카운트가 v-1 개가 되면, 신장트리 완성
                    break;
                }
            }
        }
        System.out.println(result);
    }
}