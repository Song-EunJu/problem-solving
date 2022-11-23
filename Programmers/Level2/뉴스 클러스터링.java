// 1. 어떤 알고리즘 써야할까
// 2. 구현은 어떤 방식으로 해야할까

/*
1. 일단 문자열 들어온 애들을 2자리씩 끊어서 배열로 만든다
-> 잘랏을 때 영문자로만 이루어진게 아니면 그 자리에서 버림
-> 그러려면 배열 크기 지정못하니까 리스트로 받는다

2. Map 연산을 통해 각 문자열이 몇번씩 나온지 계산
-> 리스트 2개를 돌면서 HashMap<String, Integer> 에 저장하면서, 같은 문자열 반복된 게 몇 번 나오는 지까지 계산
ex) (FR,2) (SK,1)

Map 을 2개를 쓰지말고 전체 통합해서 1개만 쓰면서, 이미 있는 key값인 경우에는 List<Integer> 에 min 값을 저장해 둠
그리고 해당 리스트에 들어있는 값을 더한 값이 분자가 됨

그리고 Map에 있는 value 값을 다 더한 게 합집합으로서 분모값이 된다.

++ Character.isLetter() 메소드 -> char 값이 문자인지 판단하여 TF 반환
++ 리스트의 retainAll() -> 두 개의 리스트에서 교집합
++ 리스트의 합집합 addAll() -> 두 개의 리스트에서 합집합
*/
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 문자열을 2자리 씩 쪼개서 list로 만드는 과정
        putInList(str1, list1);
        putInList(str2, list2);

        if(list1.size()==0 && list2.size()==0)
            return 1*65536;

        // list에서 한번에 map 에 넣는 경우에는 min(a,b) 계산을 제대로 할 수가 없음
        // 따라서 각각 list 를 map 에 넣어서 <해당 문자열이 몇 번씩 나오는지> 계산
        putInMap(list1, map1);
        putInMap(list2, map2);

        // 교집합은 min(a,b) 이므로 교집합인 문자열의 min 값을 저장할 list 선언
        List<Integer> minList = new ArrayList<>();

        for(String key : map2.keySet()){
            if(map1.get(key) != null){ // map1에 이미 있는 애면 map1 이랑 map2 중에 작은 값을 minList에 넣고 큰 값은 map1 에 업데이트
                int min = Math.min(map1.get(key), map2.get(key));
                int max = Math.max(map1.get(key), map2.get(key));

                minList.add(min);
                map1.put(key, max);
            }
            else // map2 에만 있는 애면 map1 에 넣어서 합치기
                map1.put(key, map2.get(key));
        }

        double top = minList.stream().mapToInt(x->x).sum();
        double bottom = 0;

        // 분모 계산 (합집합)
        for(String key: map1.keySet()){
            bottom += map1.get(key);
        }

        return (int)((top/bottom)*65536);
    }

    public static void putInList(String strs, List<String> list){
        for(int i=0;i<strs.length()-1;i++){
            String str = strs.substring(i, i+2);
            if(str.charAt(0) >= 'a' && str.charAt(0) <='z' && str.charAt(1) >= 'a' && str.charAt(1) <= 'z')
                list.add(str);
        }
    }

    public static void putInMap(List<String> list, Map<String, Integer> map){
        for(int i=0;i<list.size();i++){ // 리스트에 있는 문자열을 돌면서 map 에 넣음
            if(map.get(list.get(i)) != null) {// 해당 문자열이 map 에 이미 있는 경우
                map.put(list.get(i), map.get(list.get(i))+1);
            }
            else
                map.put(list.get(i), 1);
        }
    }
}