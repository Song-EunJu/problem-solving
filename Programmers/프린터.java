import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        /*
            해당 location 의 value가 몇 번째에 출력되는지 알아야 하기 때문에 (순서, 우선순위)를 모두 담기위해 HashMap 사용
            순서 보장하면서 넣기 위해 LinkedHashMap 사용
        */


        /*
            map 에 넣으면서 현재상태에서 최댓값을 구함
        */
        int max=0;
        for(int i=0;i<priorities.length;i++){
            map.put(i,priorities[i]);
            max=Math.max(max, priorities[i]);
        }


        /*
            ex) priorities [2,1,3,2]       location=2 즉, (2,3) 이 몇번째에 출력될 것인지를 리턴
                map (0,2)   (1,1)   (2,3)
                    (1,1)   (2,3)   (3,2)
                    (2,3)   (3,2)   (0,2)
                    (3,2)   (0,2)   (1,1)
        */

        Set<Integer> keys = map.keySet(); // HashMap의 key 값들만 가져옴

        while(true){

            for(Integer key : keys){

                if(map.get(key) == max){   // value가 max 값인 경우
                    answer++;
                    if(key==location){ // max면서 location이 key와 같은 경우
                        return answer;
                    }
                    else{
                        map.remove(key); // max지만 location이 key와 다른 경우
                        keys = map.keySet();
                        max=0;
                        for(Integer newKey : keys){   // max 값 다시 정하기
                            max = Math.max(max, map.get(newKey));
                        }
                        break;
                    }
                }
                else{ // value가 max가 아닌경우
                    int saveKey = key;
                    int saveValue = map.get(key);

                    map.remove(key); // 첫번째에서 빼서
                    map.put(saveKey, saveValue); // 맨 뒤에 다시 넣기
                    break;
                }
            }
        }
    }
}