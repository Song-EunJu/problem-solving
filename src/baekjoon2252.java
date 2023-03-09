//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class baekjoon2252 {
//    static class Node {
//        int vertex;
//        Node link;
//
//        public Node(int vertex, Node link) {
//            this.vertex = vertex;
//            this.link = link;
//        }
//    }
//
//    static int N, M;
//    static Node[] adjList;
//    static int[] inDegree;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken()); // 학생 수
//        M = Integer.parseInt(st.nextToken()); // 비교해본 횟수
//        adjList = new Node[N + 1]; // 정점개수만큼 인접 리스트 만듦
//        inDegree = new int[N + 1];
//
//        // 이중 연결리스트 만들고
//        // 해당 연결리스트에서 size() 가 0 인 애들을 큐에 다 넣음
//        // 큐에서 꺼내서 for문을 돌면서 자기자신을 자식으로 가지고 있는 애들에서 다 없애기
//        int from, to;
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            from = Integer.parseInt(st.nextToken());
//            to = Integer.parseInt(st.nextToken());
//            adjList[from] = new Node(to, adjList[from]);
//            inDegree[to]++;
//        }
//        ArrayList<Integer> result = topologySort();
//        for(int res : result)
//            System.out.print(res+" ");
//    }
//
//    static ArrayList<Integer> topologySort(){
//        ArrayList<Integer> orderList = new ArrayList<>();
//        Queue<Integer> queue = new ArrayDeque<>();
//        for(int i=1;i<=N;i++){
//            if(inDegree[i] == 0)
//                queue.add(i);
//        }
//
//        while(!queue.isEmpty()){
//            int cur = queue.poll();
//            // 큐에서 나오는 애들 추가
//            orderList.add(cur);
//
//            // 현재 정점 기준으로 인접정점 처리
//            for(Node temp = adjList[cur]; temp != null; temp = temp.link){
//                if(--inDegree[temp.vertex] == 0)
//                    queue.add(temp.vertex);
//            }
//        }
//        return orderList;
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon2252 {
    static int N, M;
    static int inDegree[];
    static List<Integer>[] nodeList;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 비교해본 횟수
        nodeList = new ArrayList[N+1]; // 인접리스트
        inDegree = new int[N+1]; // 진입차수 저장배열

        for(int i=0;i<N+1;i++){
            nodeList[i] = new ArrayList<>();
        }

        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            nodeList[from].add(to);
            inDegree[to]++;
        }
        topologySort();
    }

    static void topologySort(){
        Queue<Integer> queue = new ArrayDeque<>();

        // 1. 진입 차수가 0인 노드, 즉 시작점이 될 수 있는 정점을 큐에 삽입
        for(int i=1;i<=N;i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur+" ");

            // 2. 현재 정점 기준으로 인접한 정점들의 진입차수를 1개씩 감소시키고, 0이 된다면 큐에 넣기
            for(int n: nodeList[cur]){
                if(--inDegree[n] == 0)
                    queue.add(n);
            }
        }
        System.out.println(sb);
    }
}