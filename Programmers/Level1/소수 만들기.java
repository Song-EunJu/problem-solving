import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int h=0;

        // [1,2,3,4] 라고 치면 여기서 3개씩 뽑아서 3중 for문을 돌렸어요

        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(isPrime(sum)){
                        h++;
                    }
                }
            }
        }
        return h;
    }

    public boolean isPrime(int n){
        for(int i=2;i<=n/2;i++){
            /*
                ex) 8 = 8은 자기 자신을 제외하고 4보다 큰 약수를 가질 수 없음
                    그래서 2부터 n/2 까지의 수 중에 나누어 떨어지는 게 있는지 확인한다
            */
            if(n%i==0) // 소수가 아닌 경우
                return false;
        }
        return true;   // 소수인 경우에만 h++
    }
}