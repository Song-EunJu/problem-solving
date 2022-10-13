// 이중 포문쓰면 안될 줄 .... 스택으로 생각하다가 해결 못함
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0;i<prices.length;i++){
            answer[i] = prices.length-(i+1); // 처음엔 무조건 가격 떨어질 일 없다고 가정하고 초기화
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<prices[i]){ // 나보다 가격 낮은 애가 처음으로 나오는 순간 answer 값 세팅
                    answer[i]=j-i;
                    break;
                }
            }
        }
        return answer;
    }
}


// 스택을 사용한 풀이
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<prices.length; i++){

            // 스택에 들어가려는 값이, 현재 스택 제일 상단의 값보다 작은 경우
            // == 가격이 떨어진 경우
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int idx = stack.pop(); // 현재 스택에서 값이 제일 컸던 애의 인덱스 추출
                // 현재인덱스에서 값이 제일 컸던 애의 인덱스 값을 빼서 저장
                answer[idx] = i - idx;
            }
            stack.push(i); //
            // 스택에 들어가려는 값이, 현재 스택 제일 상단의 값보다 큰 경우
            // == 즉, 가격이 떨어지지 않은 경우의 인덱스를 스택에 넣기
        }
        System.out.println(stack);

        while(!stack.isEmpty()){
            int leftIdx = stack.pop();
            answer[leftIdx] = len-leftIdx-1;
        }

        return answer;
    }
}