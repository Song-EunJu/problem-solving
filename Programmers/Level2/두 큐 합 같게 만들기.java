import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0;i<queue1.length;i++){
            q1.add(queue1[i]);
            sum1 += queue1[i];

            q2.add(queue2[i]);
            sum2 += queue2[i];
        }

        if((sum1+sum2)%2!=0)
            return -1;

        while(sum1 != sum2){ // 같지 않은 동안, 여기서 큐를 순회할 수 있는
            if(q1.isEmpty() || q2.isEmpty() || answer>=queue1.length*3)
                // 한쪽 큐가 비어있는 경우엔 불가능(=1개의 원소가 나머지 수의 합보다 큰 경우)
                // 큐가 양쪽을 서로 바꿔치기한 경우에도 안될 듯 -> queue1.length*2 라고 생각하기 쉬운데
                // [1,1,1,1,1] [1,1,1,9,1] 의 경우는 큐2가 큐1로 9까지 갔다가 큐1에 있는 애를 다 뺀 경우 12번을 돌아야 됨
                // 따라서 *2까지는 불가능한 경우가 아님
                return -1;
            if(sum2 > sum1){ // queue2의 값이 더 큰 경우
                // 일단 큐2에 있는 값을 빼서 큐1에 넣는다
                int n = q2.poll();
                sum2 -= n;
                q1.add(n);
                sum1 += n;
            }
            else{
                // 일단 큐1에 있는 값을 빼서 큐2에 넣는다
                int n = q1.poll();
                sum1 -= n;
                q2.add(n);
                sum2 += n;
            }
            answer++;
        }

        // 원소의 합을 같게 만들 수 없는 경우 -> 합이 홀수인 경우
        return answer;
    }
}