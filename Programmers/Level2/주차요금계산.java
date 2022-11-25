/*
[첫 접근]
- records 배열을 차량 번호 순으로 정렬함
- 입차가 나온순간 그다음 인덱스에 출차가 있는 지 확인. -> 만약 없다면 23:59로 세팅하고 계산
-> 출차가 없다면 출차 값을 세팅해두고 그 다음에 계산
-> 출차가 나온 순간 그전 인덱스 입차에 접근해서 차를 계산함.

*/
// 아래와 같은 배열 형태로 만들었음
// 06 00	0000    0
// 06 34	0000    1
// 18 59	0000	0

// 07 59	0148	0
// 19 09	0148	1
// 05 34	5961	0
// 07 59	5961	1
// 22 59	5961	0
// 23 00	5961	1

import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        int[][] recordStr = new int[records.length][4];
        for(int i=0;i<records.length;i++){
            String[] str = records[i].split(" ");
            String[] time = str[0].split(":");

            recordStr[i][0] = Integer.parseInt(time[0]);
            recordStr[i][1] = Integer.parseInt(time[1]);
            recordStr[i][2] = Integer.parseInt(str[1]);
            recordStr[i][3] = str[2].equals("IN") ? 0 : 1;
        }

        // 차량번호 순으로 records 배열 정렬
        Arrays.sort(recordStr, (o1, o2) -> {
            return o1[2] - o2[2];
        });


        int time = 0;
        for(int i=0;i<recordStr.length;i++){
            if(i < recordStr.length-1 && recordStr[i+1][3] - recordStr[i][3] == 1) { // 입차, 출차가 세트로 있는 경우
                time += (recordStr[i+1][0] - recordStr[i][0])*60;
                time += recordStr[i+1][1] - recordStr[i][1];
                i++; // 입차, 출차 세트로 계산했으니까 인덱스를 하나 늘려주기
            }
            else { // 입차만 있는 경우
                time += (23 - recordStr[i][0])*60;
                time += (59 - recordStr[i][1]);
            }

            // 1. 인덱스 범위를 벗어나지 않으면서, 다음 턴에 차번호가 달라지는 경우
            // 2. 마지막 인덱스인 경우에
            // 지금까지 계산한 time에 대한 money 를 구해야 함
            if((i < recordStr.length-1 && recordStr[i+1][2] != recordStr[i][2]) || (i == recordStr.length-1)) {
                int baseTime = fees[0];
                int baseMoney = fees[1];
                int unitTime = fees[2];
                int unitMoney = fees[3];
                int money = baseMoney;

                if(time > baseTime){
                    int upTime = (time-baseTime)%unitTime == 0 ? (time-baseTime)/unitTime : (time-baseTime)/unitTime+1;
                    money += upTime*unitMoney;
                }
                answer.add(money);
                time = 0;
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}