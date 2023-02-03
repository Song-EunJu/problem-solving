// B 팀원들이 얻을 수 있는 최대 승점 구하기
/*
 완탐 -> 팀원수가 100000인 경우 택도 없을 듯

 A의 각 원소보단 크지만, 현재 리스트에 있는 값 중엔 작은 것으로 고르기
 + 생각하지 못한 점 : 그런데 큰 수부터 상대해야 한다
 ++ 살짝 생각했지만 확신하지 못한 점 : A의 순서가 꼭 저래야 할까? 큰 수부터 정렬해서 하면 안되려나?
    -> 큰 수부터 정렬해서 해도 됨.

   [다른 사람 풀이]
   B 가 큰 경우에는 j-- 를 하면서 j의 인덱스도 줄여주면서 A원소값이랑 계속 비교함
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
            if(A[i] < B[j]) {
                answer++;
                j--;
            }
        }
 
*/
import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        LinkedList<Integer> listA = new LinkedList<>();
        for(int i=0;i<A.length;i++){
            listA.add(A[i]);
        }
        // A팀을 내림차순 정렬
        Collections.sort(listA, (o1, o2) -> o2 - o1);

        // B팀을 내림차순 정렬
        LinkedList<Integer> listB = new LinkedList<>();
        for(int i=0;i<B.length;i++){
            listB.add(B[i]);
        }
        Collections.sort(listB, (o1, o2) -> o2 - o1);

        while(listB.size() != 0){
            if(listA.peek() < listB.peek()){ // B의 값이 더 크다면
                answer++;
                listA.poll();
                listB.poll();
            }
            else {
                listB.pollLast();
                listA.poll();
            }
        }
        return answer;
    }
}