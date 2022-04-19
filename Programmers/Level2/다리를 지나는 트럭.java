import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<Integer>();
        int idx=0;
        int second=0;
        int sum=0;
        while(true){
            if(idx>=truck_weights.length)
                break;

            if(idx<truck_weights.length){
                if(q.size()==bridge_length)
                    sum-=q.poll(); // 큐에서 제거하면서 해당 값은 sum 에서도 빼줌

                int num = truck_weights[idx];
                if(sum+num<=weight){
                    sum+=num; // 큐에 추가할 때는 sum 에도 더해줌
                    q.offer(num);
                    idx++;
                }
                else
                    q.add(0);
            }
            else
                q.add(0);
            second++;
        }
        return second+bridge_length;
        // 마지막 하나 요소가 다리를 빠져나가기 위해서 다리 길이만큼 초가 필요함
    }
}