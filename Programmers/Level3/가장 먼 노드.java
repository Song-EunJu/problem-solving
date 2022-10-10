// 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인가
// 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드

// '1번 노드'로부터만 구하면 되니까 다익스트라, BFS
import java.util.*;
class Node{
    int number;
    int deep;

    Node(int number, int deep){
        this.number = number;
        this.deep = deep;
    }
}
class Solution {
    static boolean visited[];
    static int dist[];

    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n+1];
        dist = new int[n+1];

        bfs(1, edge);

        // 최댓값이 무엇인지 구해서 개수구하는 코드
        int max = 0;
        for(int i=0;i<dist.length;i++){
            max = Math.max(dist[i], max);
        }

        for(int i=0;i<dist.length;i++){
            if(dist[i] == max)
                answer++;
        }
        return answer;
    }

    /*
    처음에 큐를 노드 번호만 담으려고 Queue<Integer>로 선언했는데, 그렇게 하면 깊이를 세는데서 문제가 생김
    그냥 while문 한번 턴 돌때마다 cnt++ 해주면서 계산하면 될 줄 알았는데
    1번 노드와 연결된 애 (3번, 2번) 을 순서대로 큐에 넣고
    3번부터 꺼내고 4,6번을 넣고
    2번을 꺼내서 5번을 넣는 과정에서
    ** 3번과 연결된 애가 2번과 연결된 애랑 cnt 가 동일하지 않는 문제가 생김

    그래서 Node 라는 클래스를 선언해서 깊이까지 같이 저장하고 큐에서 꺼낼때 그놈에서 +1씩해서 깊이를 구해줬음
    -> dist 배열에서 꺼내와서 +1 해줘도 됐네 ...

    */
    public void bfs(int num, int[][] edge){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(num,1));
        visited[num] = true;

        while(!q.isEmpty()){ // 큐가 비어있지 않은 동안
            Node node = q.poll();
            int number = node.number;
            int deep = node.deep;

            for(int i=0;i<edge.length;i++){
                int a = edge[i][0];
                int b = edge[i][1];

                /*
                비방향성 그래프니까, a/b인 경우일 때를 나눠서 체크해주고, 한번 방문한 애는 false 처리
                */
                if(a == number && visited[b] == false){
                    dist[b] = deep+1;
                    q.add(new Node(b, deep+1));
                    visited[b] = true;
                } else if(b == number && visited[a] == false){
                    dist[a] = deep+1;
                    q.add(new Node(a, deep+1));
                    visited[a] = true;
                }
            }
        }
    }
}
