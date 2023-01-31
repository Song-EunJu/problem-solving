import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();

        // 1. hashMap 에 A-Z 까지 초기화
        Map<String, Integer> map = new HashMap<>();
        char startChar = 'A';
        for(int i=1;i<=26;i++){
            map.put(Character.toString(startChar++), i);
        }

        StringBuilder sb = new StringBuilder(msg);
        while(sb.length()!=0){
            // 2. 가장 긴 문자열 찾고, 리스트에 추가하고, w 제거
            String str = "";
            int i;
            for(i=sb.length();i>0;i--){
                str = sb.substring(0, i);
                if(map.get(str) != null){
                    list.add(map.get(str));
                    break;
                }
            }
            sb.delete(0, i);

            // 4. 다음 글자가 있다면 w+c 사전에 등록
            if(sb.length()!=0){
                String newStr = str+String.valueOf(sb.charAt(0));
                map.put(newStr, map.size()+1);
            }
        }

        int answer[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}