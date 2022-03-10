import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        /*

        진도    95 90 99 99 80 99
    개발 속도    1  1  1  1  1  1
        일수    5  10 1  1  20  1

        5일째에는 1개
        10일째에는 3개
        20일째에는 2개

        */

        // 각 기능의 개발 일수 계산
        for(int i=0;i<progresses.length;i++){
            int day = (100-progresses[i])/speeds[i];

            if((100-progresses[i])%speeds[i]==0) // 딱 떨어지는 경우
                queue.offer(day);
            else
                queue.add(day+1); // 딱 떨어지지 않는 경우 +1
        }

        /*
            현재 큐 : 5  10  1  1  20  1
        */

        // 각 배포마다 몇 개의 기능이 배포될지 계산
        while(!queue.isEmpty()){
            int count=1;
            int num = queue.poll(); // 
            while(queue.peek()!=null && queue.peek()<=num){
                count++;
                queue.poll();
            }
            list.add(count);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}
