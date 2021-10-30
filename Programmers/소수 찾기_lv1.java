class Solution {
    public int solution(int n) {
        int i,j;
        int count=0;
        for(i=2;i<=n;i++){
            for(j=2;j<=n/2;j++){
                if(i%j==0)
                    break;
            }
            if(j==n/2)
                count++;
         // 에라토스테네스의 체 
        }
        return count;
    }
}
