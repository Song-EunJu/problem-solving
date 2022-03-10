import java.util.*;
class Solution {
    public int[] solution(long n) {

        // 1번 - 이게 훨씬 빠름
        String num = Long.toString(n);
        int[] answer = new int[num.length()];

        for(int i=num.length()-1;i>=0;i--){
            answer[num.length()-i-1]=num.charAt(i)-'0';
        }

        return answer;

        /* 2번
        ArrayList<Integer> list = new ArrayList<>();

        while(n>0){
            int num = (int)(n%10);
            n/=10;
            list.add(num);
        }

        return list.stream().mapToInt(i->i).toArray();
        */

    }
}