class Solution {
    public long[] solution(int x, int n) {
        // 3.
        long[] answer = new long[n];
        for(int i=0;i<n;i++){
            if(x==0)
                answer[i]=0; 
            else
                answer[i]=(long)x*(i+1);
        }
        return answer;
    }
}
