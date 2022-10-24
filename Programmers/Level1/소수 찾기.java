class Solution {
    public int solution(int n) {
        int count = 0;

        for(int i=2;i<=n;i++){
            int cnt = 0;
            for(int j=2;j*j<=i;j++){
                if(i%j == 0){
                    cnt++;
                    break;
                }
            }
            if(cnt == 0)
                count++;
        }
        return count;
    }
}