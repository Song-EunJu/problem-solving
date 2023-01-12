import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            int tNum = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new LinkedHashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                int n = Integer.parseInt(st.nextToken());
                if(map.containsKey(n)) // map 에 포함된 원소라면 map.get(n) != null 이렇게 하지말자
                    map.put(n, map.get(n)+1);
                else // map 에 포함되지 않은 원소라면
                    map.put(n, 1);
            }

            // HashMap value 기준 정렬
            // Collections.sort() 를 사용하기 위해 List 형태로 Map 가져와야 함

            List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
            // 최빈값이 동일한 게 있으면 숫자가 큰 것 출력해야 하므로 일단 숫자 key 로 정렬
            entryList.sort((o1, o2) -> o2.getKey() - o1.getKey());

            // value 값 (빈도 수) 기준으로 정렬
            entryList.sort((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey()));

            // map 출력하기
//            for(Map.Entry<Integer, Integer> entry: entryList){
//                System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
//            }

            // entryList 의 제일 첫번째 요소가 가장 큰 최빈값
            System.out.println("#"+tNum+" "+entryList.get(0).getKey());
        }
    }
}
