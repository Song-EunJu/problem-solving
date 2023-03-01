// 유니온 파인드로 푼 sk 플래닛 코테 2번 문제
// 더 간결한 코드

import java.util.Arrays;

class skp2_3 {
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
        System.out.println(Arrays.toString(p));
    }

    public static int[] solution(int[] p, int[] b) {
        int answer[] = new int[b.length];
        /**
         * 현재 p 배열 : 2 2 -1 1 5 -1 5
         * -1 인 아닌 애들한테 경로 압축 시도함.
         * 현재 p[i] 가 가지고 있는 값이, 실제로도 보스라면 p[i] 가 가지고 있는 값의 인덱스에 접근하여
         * depth 를 하나 늘려준다 (마이너스 하는 작업)
         * -> 이렇게 되면 보스인 애들 아래에 딸린 애들이 몇명인지 보스 인덱스가 가지고 있을 수 있음
         * */
        for(int i=0;i<p.length;i++) {
            if (p[i] > 0) { // 보스가 아닌 경우
                if(findSet(p, i) == p[i])
                    --p[p[i]];
            }
        }

        // 마이너스 값을 가진 원소가 보스
        for(int i=0;i<b.length;i++){
            answer[i] = p[b[i]] < 0 ? (-1)*p[b[i]] : 0;
        }

        return answer;
    }

    public static int findSet(int[] p, int num){
        if(0 > p[num]) // 보스인 경우
            return num;

        return p[num] = findSet(p, p[num]);
    }
}



