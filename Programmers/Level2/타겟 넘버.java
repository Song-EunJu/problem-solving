// 옛날에 배낀 버전
class Solution {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        int start = numbers[0];
        answer += dfs(numbers, target, start, 1);
        answer += dfs(numbers, target, -start, 1);
        return answer;
    }


    public int dfs(int[] numbers, int target, int sum, int idx){
        if(idx==numbers.length){
            if(sum==target)
                return 1;
            else
                return 0;
        }
        int ans = 0;
        ans+=dfs(numbers, target, sum+numbers[idx], idx+1);
        ans+=dfs(numbers, target, sum-numbers[idx], idx+1);
        return ans;
    }
}


/** @date : 2022.10.08 */

// 타겟 넘버를 만드는 방법의 수
// sum 값을 +, - 하면서 sum 값을 애초에 바꿔줘버린 게 문제가 됐음
// sum+=numbers[idx] 로 sum값을 바꿔줘버리면서 인자로 받은 sum 값이 바껴버리고
// 바뀐 값에서 numbers[idx] 를 뺀 연산을 시작하니까 답이 이상하게 나옴

class Solution {
    static int ans = 0;
    public int solution(int[] numbers, int target) {
        ans += dfs(0, 0, numbers, target);
        return ans;
    }

    public int dfs(int sum, int idx, int[] numbers, int target){
        if(idx == numbers.length){
            if(sum == target)
                return 1;
            else
                return 0;
        }
        int answer = 0;
        // sum += numbers[idx];
        answer += dfs(sum+numbers[idx], idx+1, numbers, target);

        // sum -= numbers[idx];
        answer += dfs(sum-numbers[idx], idx+1, numbers, target);
        return answer;
    }
}

