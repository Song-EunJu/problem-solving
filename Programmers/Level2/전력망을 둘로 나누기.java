import java.util.*;
class Solution {
    static boolean point[][];
    public int solution(int n, int[][] wires) {
        int answer = n;
        point = new boolean[n+1][n+1]; // 인접행렬로 나타냄

        // 비방향성 그래프이므로
        for(int i=0;i<wires.length;i++){
            point[wires[i][0]][wires[i][1]] = true;
            point[wires[i][1]][wires[i][0]] = true;
        }

        for(int i=0;i<wires.length;i++){ // 선 끊기
            int p = wires[i][0];
            int q = wires[i][1];
            point[p][q] = point[q][p] = false; // 선 끊기
            answer = Math.min(answer, bfs(n, p)); // 가장 작은 차이 계산하기
            point[p][q] = point[q][p] = true;
        }
        return answer;
    }

    public int bfs(int n, int p){
        boolean visit[] = new boolean[n+1];
        int cnt=1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(p); // 정점을 큐에 넣고

        while(!queue.isEmpty()){
            int vertex = queue.poll(); // 큐에서 빼고
            visit[vertex] = true; // 해당 정점을 방문했고

            for(int i=1;i<=n;i++){ // vertex 와 연결된 애들 중 방문한적 없는 노드 전부 큐에 넣기
                if(visit[i]==true) // 이미 방문했다면 암것도 안함
                    continue;
                if(point[vertex][i]==true){ // 정점이 연결되어 있다면
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        return (int)Math.abs(n-2*cnt); //cnt-(n-cnt) = cnt-n+cnt = -n+2*cnt
    }
}