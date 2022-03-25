// 이 전 행의 값으로부터 더해질 수 있는 가장 큰 수를 찾자
import java.util.*;
import java.io.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int last = land.length-1;
        for(int i=1;i<land.length;i++){ // 1행부터 for문 돌면서
            for(int j=0;j<4;j++){
                int max=0;
                for(int k=0;k<4;k++){
                    if(j!=k){ // 전 행과 같은 열이 아닌 값들 중에서
                        if(land[i-1][k]>max)
                            max = land[i-1][k]; // 최대값을 찾고
                    }
                }
                land[i][j]+=max; // 그 값으로 업데이트
            }
        }

        // 마지막 출력용
        int max=0;
        for(int i=0;i<4;i++){
            if(land[last][i]>max)
                max=land[last][i];
        }
        return max;
    }
}