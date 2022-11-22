// 캐시 크기에 따른 실행시간 측정 프로그램을 작성
/* LRU

List의 id : 0 (오래된 데이터)
새로운 데이터 삽입 시 0 을 가장 먼저 삭제하고, 제일 뒤에 데이터 삽입
캐시에 적재된 데이터 사용 시, 해당 데이터를 제일 뒤로 옮겨 가장 최근에 사용된 값임을 알린다.
*/
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        int idx = 0;
        List<String> list = new ArrayList<>(cacheSize);
        if(cacheSize == 0)
            return cities.length*5;

        for(int i=0;i<cities.length;i++){
            String city = cities[i].toLowerCase();

            // cache hit인 경우, 이미 존재하는 도시의 인덱스를 삭제하고 맨 뒤에 다시 도시를 넣음
            if(list.contains(city)){
                time+=1;
                list.remove(list.indexOf(city));
                list.add(city);
            }
            // cache miss인 경우,
            else {
                time+=5;
                if(list.size() != cacheSize){ // 가득 차있지 않으면 리스트에만 넣고
                    list.add(city);
                }
                else{ // 가득차있는 경우라면, 맨 앞에 있는 애를 삭제하고 맨 뒤에 다시 도시를 넣음
                    list.remove(0);
                    list.add(city);
                }
            }
        }
        return time;
    }
}