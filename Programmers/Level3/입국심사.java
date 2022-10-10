/* 모든 사람이 심사 받는데 걸리는 시간의 최솟값을 구하자
 새로운 사람이 들어가야 할 때, 자기 앞에 times.length() 만큼
 사람들이 들어갔던 자리 + 가장 조금 기다리고 빨리 끝나는 시간 확인

*/
// import java.util.*;
// class Solution {
//     public long solution(int n, int[] times) {
//         long answer = 0;
//         int[] people = new int[n]; // 몇분 기다리는 지 저장할 배열
//         Arrays.sort(times);
//         Arrays.fill(people, Integer.MAX_VALUE);

//         // people 배열에 해당 사람들의 시작 시간 넣음 (초기 세팅은 0)
//         for(int i=0;i<times.length;i++){
//             people[i]=times[i];
//         }

//         for(int i=times.length;i<people.length;i++){
//             int min = Integer.MAX_VALUE;
//             for(int j=i-times.length;j<i;j++) {
//                 // 계산 필요한 위치부터 times 배열 만큼 back해서 거기서부터 min 값 계산해보기
//                 min = Math.min(people[i-times.length] + (people[j]-people[i-times.length]) + times[j%times.length], min);
//             }
//             people[i] = min;
//         }

//         return people[n-1];
//     }
// }

// 걸리는 시간의 최솟값, 최댓값을 지정해두고 그 시간안에 사람들의 심사가 가능한지 체크하고
// 가능한 경우 계속 시간의 범위를 줄여
// 불가능한 경우 시간의 범위를 늘려
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long max = 0;
        for(int i=0;i<times.length;i++){
            max = Math.max(times[i], max);
        }

        // 시간의 최소, 최댓값 구하기
        long left = 0;
        long right = max*n;
        long answer = right;

        while(left<=right){
            long mid = (left+right)/2;

            /*
            mid 초 안에 검사가 가능한지 체크하는 로직을 어떻게 짜야할까라는 고민을 했음
            -> 시간의 범위는 정했으니까, 그 시간 내에 몇명을 심사할 수 있는지를 체크하자
            -> mid초를 times 배열로 나눠가면서 최대 심사가능한 인원을 확인하고
            -> n명보다 많으면 시간 최댓값을 줄이고, n명보다 적으면 시간최솟값을 늘리고
            */
            long sum = 0;
            for(int i=0;i<times.length;i++){
                sum+=mid/times[i];
            }

            if(sum >= n) {// 시간 안에 n명 이상 테스트 가능하면
                answer = Math.min(answer, mid);
                right = mid-1;
            }
            else if(sum < n) // 불가능하면
                left = mid+1;
        }
        return answer;
    }
}