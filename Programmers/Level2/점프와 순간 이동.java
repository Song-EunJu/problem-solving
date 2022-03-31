/*
    - 2의 배수인 경우, 절반한 거랑 동일
    3 = 1+(1)+1
    6 = 1+(1)+1+(3)

    - 홀수인 경우, 이전 거+1
    4 = 1+(1)+(2)
    5 = 1+(1)+(2)+1
*/
/* 시간 초과 + 메모리 초과
public class Solution {
    public int solution(int n) {
        int dp[] = new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            if((i&(i-1))==0) // 2의 제곱수인 경우
                dp[i]=1;
            else if(i%2==0) // 2의 제곱수가 아닌데 2의 배수
                dp[i]=dp[i/2];
            else // 홀수인 경우
                dp[i]=dp[i-1]+1;

        }
        return dp[n];
    }
}
*/

public class Solution {
    public int check(int n){
        if(n==1)
            return 1;
        else if(n%2==0)
            return check(n/2);
        else
            return check(n-1)+1;
    }
    public int solution(int n) {
        int answer =check(n);
        return answer;
    }
}