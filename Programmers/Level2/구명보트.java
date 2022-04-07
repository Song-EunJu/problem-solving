/*
    - 가장 가벼운 사람 + 가장 무거운 사람 > limit 인 경우, max 를 감소시켜 짝지을 사람 탐색
    - 가장 가벼운 사람 + 가장 무거운 사람 < limit 인 경우, 둘이 짝지어지므로 min 은 증가, max는 감소
*/
class Solution {
    public int solution(int[] people, int limit) {
        int answer=0;
        int min=0;
        int max=people.length-1;
        Arrays.sort(people);

        for(int i=0;i<people.length;i++){
            int cnt=0;
            if(people[min]+people[max]>limit)
                max--;
            else{
                min++;
                max--;
            }
            answer++;
            if(min > max){
                break;
            }

        }
        return answer;
    }
}

/*
    - 효율성 초과
    1. int array to integer list _ java
        - Arrays.stream(배열)
        - boxed() : primitive type -> wrapper class type
*/
// import java.util.*;
// class Solution {
//     public int solution(int[] people, int limit) {
//         int answer=0;

//         // 1. list에 옮겨서 오름차순 정렬
//         List<Integer> list = new ArrayList<Integer>(people.length);
//         for(int i : people){
//             list.add(i);
//         }
//         Collections.sort(list);


//         while(!list.isEmpty()){
//             int first=0;
//             int last=list.size()-1;
//             if(first == last){ // 하나 밖에 안남은 경우
//                 answer++;
//                 break;
//             }

//             while(true){
//                 if(first==last){
//                     if(list.size() == people.length) // 처음 값부터 짝이 없다면 모두가 짝이 없는 것이므로
//                         return people.length;
//                     else
//                         break;
//                 }
//                 if(list.get(first)+list.get(last)>limit) // 더했을 때 limit 보다 큰 경우에 다시 돌아가기
//                     last--;
//                 else {
//                     list.remove(last);
//                     break;
//                 }
//             }
//             list.remove(0); // 무조건 첫번째거는 삭제
//             answer++;
//         }
//         return answer;
//     }
// }