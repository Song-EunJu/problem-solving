import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        // 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return
        // list에 0-9까지 넣어놓고 for문 돌면서 있는거 다 뺌
        int answer=0;
        // ArrayList<Integer> list = new ArrayList<>({0,1,2,3,4,5,6,7,8,9});
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

        for(int i=0;i<numbers.length;i++){
            if(list.contains((Integer)numbers[i])){ // contains(a) : a가 있는지 확인
                list.remove((Integer)numbers[i]);
                // remove(int index) or remove(Object o) : 인덱스에 해당하는 애가 있는지 or 해당 객체가 있는지
                // Object 형태로 만들어주기 위해 Integer로 casting
            }
        }
        for(int i=0;i<list.size();i++){
            answer+=list.get(i);
        }
        return answer;
    }
}