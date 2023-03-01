// 유니온 파인드로 푼 sk 플래닛 코테 2번 문제

import java.util.HashMap;
import java.util.Map;

class skp2 {
    public static void main(String[] args) {
        int[] p = {2,2,-1,1,5,-1,5};
        int[] b = {2,5};
        // 4,3 -> 2번이 속한 그룹의 조직원, 5번이 속한 그룹의 조직원 수 구하기
//        int[] b = {1,5};
//         1,5 -> 0,3 (보스가 아니면 0 출력하도록)

        int[] ar = solution(p,b);

        for(int i=0; i<ar.length; i++){
            System.out.print(ar[i]+ " ");
        }
    }

    public static int[] solution(int[] p, int[] b) {
        int answer[] = new int[b.length];
        /**
         * 현재 p 배열 : 2 2 -1 1 5 -1 5
         * -1 인 애들은 보스니까 가만히 냅두고, 
         * -1 인 아닌 애들한테 경로 압축 시도함.
         * 
         * 보스 바로 1단계 하위 자식들은 경로 압축한 값이나 지금 값이나 동일
         * */
        for(int i=0;i<p.length;i++) {
            if (p[i] != -1) { // 보스가 아닌 경우
                findSet(p, i);
            }
        } 

        /**
        * 경로 압축했으면, 보스인 애들 N명이 가진 -1 값, N명의 보스의 ID 값들만 배열에 존재함
         * ex) 2 2 2 -1 5 5 -1 -> 2, 5번이 보스인 것
         * 따라서 -1 이 아닌 경우인 애들을 map 에 넣은 경우에는 몇 개의 집단이 몇 명으로 이루어진지 알 수 있음
        * */
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<p.length;i++){
            if(p[i]!=-1) {
                // 보스까지 포함해서 집단의 인원 세야 하니까 default 값은 1
                int num = map.getOrDefault(p[i], 1);
                
                // 보스번호랑 보스 아래의 부하들 인원을 계산
                map.put(p[i], ++num);
            }
        }

        // map 에 저장된 값이 없다면 조직원인 것이므로 0 출력, map 에 저장되었다면 보스이므로 value 값 출력
        for(int i=0;i<b.length;i++){
            answer[i] = map.getOrDefault(b[i], 0);
        }
        return answer;
    }

    public static int findSet(int[] p, int num){
        if(0 > p[num]) // 보스인 경우
            return num;

        return p[num] = findSet(p, p[num]);
    }
}



