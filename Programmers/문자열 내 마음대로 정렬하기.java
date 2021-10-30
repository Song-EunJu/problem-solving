import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String []answer=new String[strings.length];
        Arrays.sort(strings); // 오름차순으로 우선 정렬해둔다. 
    
        /*
            bed car sun
        */

        Arrays.sort(strings, (o1,o2) -> o1.charAt(n)-o2.charAt(n));
        
        /*
            e a u 를 기준으로 오름차순 정렬 -> a e u -> car bed sun
        */
        
        for(int i=0;i<strings.length;i++){
            answer[i]=strings[i];
        }
        return answer;
    }
}
