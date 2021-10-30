class Solution {
    public int solution(int num) {
        int answer = num;
        int count=0;
        while(answer!=1 && count!=500){ // answer가 1이 아니고, count가 500이 아닌동안
            if(answer%2==0){
                answer/=2;
            }
            else if(answer%2==1){
                answer=answer*3+1;
            }
            count++;
        }
        if(count==500)
            return -1;
        else
            return count;
    }
}