/*
    1. 공백기준으로 String 배열에 넣는다
    2. String 배열 -> int 배열로 변환
    3. 오름차순 정렬해서 0번째 / n-1번째 뽑기

    - mapToInt : stream을 IntStream으로 변환해주는 메소드
*/
import java.util.*;
class Solution {
    public String solution(String s) {
        String answer[] = s.split(" ");
        int arr[] = Arrays.stream(answer).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        return arr[0]+" "+arr[arr.length-1];
    }
}

