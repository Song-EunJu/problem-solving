/**
 1. 문자열을 해시에 넣고
 2. 각 문자열의 일부분이 해시 key에 있는지 확인한다
 3. 일부분을 나타내기 위해서는 각 문자열 길이만큼 substring을 구해가면서 해시 key에 값이 있는 지 확인 해야 함

 - containsKey
 - startsWith

 */

// 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<phone_book.length;i++){
            map.put(phone_book[i], i);
        }

        for(int i=0;i<map.size();i++){ // 전체 문자열을 돌면서
            for(int j=0;j<phone_book[i].length();j++){ // 각 문자열의 일부분이 key에 있는지 검사
                if(map.containsKey(phone_book[i].substring(0, j)))
                    return false;
            }
        }
        return true;
    }
}