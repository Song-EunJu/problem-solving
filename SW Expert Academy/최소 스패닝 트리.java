//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class 최소스패닝트리 {
//    static class Edge {
//        private int from;
//        private int to;
//        private int weight;
//
//        // A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미
//        public Edge(int from, int to, int weight) {
//            this.from = from;
//            this.to = to;
//            this.weight = weight;
//        }
//    }
//    static int parents[];
//    static int V,E;
//    public static void main(String[] args) throws IOException {
//        // 최소 스패닝 트리 : 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//        for(int t=0;t<T;t++) {
//            st = new StringTokenizer(br.readLine());
//
//            V = Integer.parseInt(st.nextToken()); // 정점
//            E = Integer.parseInt(st.nextToken()); // 간선
//
//            // 1. 따로 정점 생성
//            makeSet();
//
//            // 2. 간선 오름차순 정렬 -> 크루스칼에서 정렬하는데 시간이 제일 많이 듦
//            PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
//                return o1.weight - o2.weight;
//            });
//
//            int result = 0;
//            for (int i = 0;i<E;i++) {
//                st = new StringTokenizer(br.readLine());
//                int from = Integer.parseInt(st.nextToken());
//                int to = Integer.parseInt(st.nextToken());
//                int weight = Integer.parseInt(st.nextToken());
//                pq.add(new Edge(from, to ,weight));
//            }
//
//            // 3. 유니온 파인드
//            int cnt = 0;
//            while(!pq.isEmpty()){
//                Edge edge = pq.poll();
//                int from = edge.from;
//                int to = edge.to;
//
//                if (union(from, to)) { // union 을 성공한 경우, 가중치를 더해줌
//                    result += edge.weight;
//
//                    // 사이클이 생기게 되는 간선을 버린 것을 제외하고 (정점-1)개만큼 간선을 연결한 경우
//                    if(++cnt == V-1)
//                        break;
//                }
//            }
//            System.out.println("#"+(t+1)+" "+result);
//        }
//    }
//    public static boolean union(int a, int b){
//        // from이랑 to 가 이미 연결된 정점인지 확인하기 위해서는 a 랑 b 의 부모를 확인해야 한다
//        int nodeA = findSet(a);
//        int nodeB = findSet(b);
//
//        // 사이클이 존재
//        if(nodeA == nodeB)
//            return false;
//
//        parents[nodeB] = nodeA;
//        return true;
//    }
//
//    public static int findSet(int num){
//        if(num == parents[num])
//            return num;
//
//        return parents[num] = findSet(parents[num]);
//    }
//
//    static public void makeSet(){
//        parents = new int[V+1];
//        for(int i=1;i<=V;i++){
//            parents[i] = i;
//        }
//    }
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
    static class Edge {
        private int from;
        private int to;
        private int weight;

        // A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    static int parents[];
    static int V,E;
    public static void main(String[] args) throws IOException {
        // 최소 스패닝 트리 : 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken()); // 정점
            E = Integer.parseInt(st.nextToken()); // 간선

            // 1. 따로 정점 생성
            makeSet();

            // 2. 간선 오름차순 정렬 -> 크루스칼에서 정렬하는데 시간이 제일 많이 듦
            PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));

            long result = 0;
            for (int i = 0;i<E;i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                pq.add(new Edge(from, to ,weight));
            }

            // 3. 유니온 파인드
            int cnt = 0;
            while(!pq.isEmpty()){
                Edge edge = pq.poll();
                if (union(edge.from, edge.to)) { // union 을 성공한 경우, 가중치를 더해줌
                    result += edge.weight;

                    // 사이클이 생기게 되는 간선을 버린 것을 제외하고 (정점-1)개만큼 간선을 연결한 경우
                    if(++cnt == V-1)
                        break;
                }
            }
            System.out.println("#"+(t+1)+" "+result);
        }
    }
    public static boolean union(int a, int b){
        // from이랑 to 가 이미 연결된 정점인지 확인하기 위해서는 a 랑 b 의 부모를 확인해야 한다
        int nodeA = findSet(a);
        int nodeB = findSet(b);

        // 사이클이 존재
        if(nodeA == nodeB)
            return false;

        parents[nodeB] = nodeA;
        return true;
    }

    public static int findSet(int num){
        if(num == parents[num])
            return num;

        return parents[num] = findSet(parents[num]);
    }

    static public void makeSet(){
        parents = new int[V+1];
        for(int i=1;i<=V;i++){
            parents[i] = i;
        }
    }
}
