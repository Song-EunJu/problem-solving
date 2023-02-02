/*
# 문제 -> 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 구하라
힙이라고 해서 어떻게 구현해야 할까 검색했다가
힙이 우선순위큐를 구현하는 방법 중 보편적으로 많이 사용되는 자료구조라고 하여
우선순위큐로 구현해볼까 ? -> PriorityQueue 를 쓰면 우선순위에 따라 뽑을 수 있는데?
-> 그러면 오름차순으로 정렬된 거를 기준으로 작은 거 2개를 뽑아보자~
-> 보통 Node 와 같은 클래스를 사용하면 클래스 내에 Comparable 를 사용해서 우선순위 정렬 조건을 지정해주는데, 얘는 Integer wrapper 클래스라 그럴 필요가 없었음
*/
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>();

        for(int i=0;i<scoville.length;i++)
            q.add(scoville[i]);

        while(!q.isEmpty()){
            int a = q.poll();
            if(q.size()==0){ // a가 마지막 원소일 때
                if(a<K) // 마지막인데 K보다 작으면 -1 리턴
                    return -1;
                else // 마지막인데 K보다 큰 경우 answer 리턴하기 위해 break
                    break;
            } else { // a가 마지막 원소가 아니지만, k 이상인 경우 모든 원소가 k이상이므로 answer 리턴
                if(a>=K)
                    break;
            }

            int b = q.poll();
            if(b == 0 && q.size() == 0)
                return -1;

            int num = a+b*2;
            q.add(num);
            answer++;
        }
        return answer;
    }
}