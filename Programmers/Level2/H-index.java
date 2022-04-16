import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int max=0;
        Arrays.sort(citations);
        int i=0;
        while(i<=citations[citations.length-1]){ // 0부터 최댓값까지 돌면서
            int cnt=0, cnt2=0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=i) // i가 h를 나타내는 것으로, cnt는 h번 이상 인용된 논문의 개수
                    cnt++;
                else
                    cnt2++;
            }
            if(i<=cnt) // h번 이상 인용된 논문개수가 h편 이상인 경우 max 값 갱신
                max=i;
            else
                break;
            i++;
        }
        return max;
    }
}