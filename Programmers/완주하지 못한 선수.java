import java.lang.*;
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for(String player : participant){
            map.put(player, map.getOrDefault(player, 0)+1);
            // 참가자 이름과 몇 번 등장한지 보여줌, 1번도 없었으면 0(디폴트) + 1
        }

        for(String player : completion){
            map.put(player, map.get(player)-1);
            // map 은 중복이 허용되지 않으므로 다시 참가자 이름과 그 참가자가 있는 경우 -1 한 값을 넣어준다.
        }

        for(String key : map.keySet()){
            if(map.get(key)!=0){
                answer=key;
                break;
            }
            // key값이 0이 아니라는 것은 완주하지 못한 선수
        }
        return answer;
    }
}