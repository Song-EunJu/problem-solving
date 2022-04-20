import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();

        // <의상종류, 의상 개수> 로 HashMap 생성
        for(int i=0;i<clothes.length;i++){
            if(hash.get(clothes[i][1])!=null){
                int num = hash.get(clothes[i][1]);
                hash.remove(clothes[i][1]);
                hash.put(clothes[i][1], ++num);
            }
            else
                hash.put(clothes[i][1],1);
        }

        /*
            HashMap 의 Key값을 이용하여 while문을 돌면서 answer 계산
            ex) 상의:6, 하의:4, 악세서리:3 인 경우 = (6+1)*(4+1)*(3+1)-1
                (옷을 입을 수 있는 경우의 수 + 1) * (옷을 입을 수 있는 경우의 수 + 1) -1 (옷을 안입는 경우)
        */
        Iterator it = hash.keySet().iterator();
        while(it.hasNext()){
            String key = it.next().toString();
            answer*=(hash.get(key)+1);
        }

        return answer-1;
    }
}