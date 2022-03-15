/*
    1. A배열에서 가장 작은 수부터 오름차순 / B배열에서는 가장 큰 수부터 내림차순 해서 순서대로 곱함

    --------- 코드 1로 하면 시간 초과 ---------
    - Arrays.sort -> import java.util
    - 배열 역순 정렬하려면 Wrapper 배열로 바꾼 후 reverseOrder() 사용
    - Collections.reverse() 는 내림차순 정렬해주는 게 아니라, 배열을 그냥 뒤집어서 출력하는 메소드
    - boxed() 메소드 :  int, long, double 요소를 Integer, Long, Double 로 변환
    - toArray(Type[]::new) : Stream을 배열로 변환
*/
import java.util.*;
class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;

        /* 코드 1
            Arrays.sort(A);
            Integer C[] = Arrays.stream(B).boxed().toArray(Integer[]::new);
            Arrays.sort(C, Collections.reverseOrder());
        */
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<A.length;i++){
            answer+=A[i]*B[A.length-1-i];
        }

        return answer;
    }
}