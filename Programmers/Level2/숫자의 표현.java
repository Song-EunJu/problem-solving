/*
    1. for 문을 돌면서 1부터 하나씩 늘려가며 sum 에 더한다.
    2. sum 이 n 값과 같아지면 answer를 하나 증가시킨다.
    3. i를 하나 증가시키고 다시 for문을 실행한다.
*/
class Solution {
    public int solution(int n) {
        int answer=0;
        for(int i=1;i<=n;i++){
            int sum=0;
            for(int j=i;j<=n;j++){
                sum+=j;
                if(sum==n){
                    answer++;
                    break;
                }
                else if(sum>=n)
                    break;
            }
        }
        return answer;
    }
}