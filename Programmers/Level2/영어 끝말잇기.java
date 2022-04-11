import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]); // 첫 단어는 그냥 삽입
        for(int i=1;i<words.length;i++){
            String now = words[i];
            String before = list.get(i-1);
            if(before.charAt(before.length()-1) == now.charAt(0)){ // 끝말잇기가 제대로 된 건지 확인
                if(!list.contains(words[i])) // 처음 나온 단어인지 확인
                    list.add(words[i]);
                else
                    return new int[]{i%n+1, i/n+1};
            }
            else
                return new int[]{i%n+1, i/n+1};
        }

        return new int[]{0,0};
    }
}