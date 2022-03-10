import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Long> list = new ArrayList<>();
        long num;
        while(n!=0){
            num=n%10;
            n/=10;
            list.add(num);
        }
        Collections.sort(list, Collections.reverseOrder());

        int length = list.size();
        for(int i=length-1;i>=0;i--){
            answer+=Math.pow(10,i)*list.get(length-i-1);
        }
        return answer;
    }
}