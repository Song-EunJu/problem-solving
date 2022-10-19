// 사람을 나열 하는 방법을 사전 순으로 나열 했을 때, k번째 방법을 return

/*

2 =
(1,2)
(2,1)

3 =
(1,2,3)
(1,3,2)
(2,1,3)
(2,3,1)
(3,1,2)
(3,2,1)

4 =
(1,2,3,4)
(1,2,4,3)
(1,3,2,4)
(1,3,4,2)

사전식배열 -> 백트래킹?
*/
import java.util.*;
class Solution {
    static boolean visited[];
    static List<Integer> list;
    static int cnt = 0;
    public int[] solution(int n, long k) {
        int[] answer = {};
        visited = new boolean[n+1];
        list = new ArrayList<>();
        backtracking(0, 1, n, k);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        // 백트래킹은 depth 와 start 가 필요하다??
        return answer;
    }

    public void backtracking(int depth, int start, int n, long k){
        if(depth == n){ // 4개의 지점을 모두 방문한 경우
            if(cnt == k){
                // 5번째 수인 경우
                return;
            }
            cnt++;
        }

        for(int i=start;i<=n;i++){
            visited[i] = true;
            list.add(i);
            backtracking(depth+1, i+1, n, k);
            visited[i] = false;
        }
        // 1을 visit 처리, backtracking (Depth = 1, start = 2)
        // 2를 visit 처리, backtracking (Depth = 2, start = 3)
        // 3을 visit 처리, backtracking (Depth = 3, start = 4)
    }
}