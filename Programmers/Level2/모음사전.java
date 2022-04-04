/*
    - 규칙을 찾아 풀기

    total = 5^5 + 5^4 + 5^3 + 5^2 + 5^1 = 3905
    ex) A로 시작하는 단어는 3905/5=781개
        AI 인 경우는 781 <A로 시작하는 단어 개수> + (781/5)*2 <AA***, AE*** 인 단어 개수> + 1
*/
class Solution {
    public int solution(String word) {
        int answer = 0;
        int total= 3905;
        String vowel="AEIOU";

        for(String str: word.split("")){
            total/= 5;
            answer+= total*vowel.indexOf(str)+1;
        }

        return answer;
    }
}

/*
    - DFS 로 풀기
    루트 노드에서 시작해서 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법

    A -> AA -> AAA -> AAAA -> AAAAA -> AAAAE -> ...
*/
import java.util.*;
class Solution {
    List<String> list = new ArrayList<>();
    void dfs(String str, int len) {
        if(len > 5)
            return;
        list.add(str);
        for(int i = 0; i < 5; i++)
            dfs(str + "AEIOU".charAt(i), len + 1);
    }

    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
}
