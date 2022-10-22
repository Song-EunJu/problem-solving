// 문제 : 사람을 나열 하는 방법을 사전 순으로 나열 했을 때, k번째 방법을 return한다
// 1,2,3 까지 갓다가 1,3,2 로 다시 돌아가야 하니까 뭔가 방문 배열을 해놓고 되돌아가는 코드가 필요할듯

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

// 시간초과 코드
import java.util.*;
class Solution {
    static boolean visited[];
    static int cnt = 1;
    static int answer[];
    static int real[];
    public int[] solution(int n, long k) {
        answer = new int[n];
        real = new int[n];
        visited = new boolean[n+1];
        backtracking(0, 1, n, k);
        return real;
    }

    public void backtracking(int depth, int start, int n, long k){
        if(depth == n){ // 4개의 지점을 모두 방문한 경우
            if(cnt == k){
                for(int i=0;i<answer.length;i++){
                    real[i] = answer[i];
                }
            }
            else if(cnt > k) // 이거 없으면 끝까지 for문을 돈다
                return;
            cnt++;
        }

        for(int i=1;i<=n;i++){
            if(visited[i] == false){
                visited[i] = true;
                answer[depth] = i;
                backtracking(depth+1, i+1, n, k);
                visited[i] = false;
            }
        }
    }
}