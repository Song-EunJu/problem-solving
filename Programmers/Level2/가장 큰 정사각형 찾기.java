/**
 * - 행 또는 열 길이가 1인 경우는 최대 크기가 1로 고정
 * - 처음엔 dp 배열을 따로 깊은 복사해서 풀었는데 board[i][j] 기준으로 왼, 위, 대각선 원소의 최솟값을 기준으로 1을 더해주면 현재 위치에서의 가장 큰 정사각형 한 변의 길이가 나옴
 * - 배열 전체를 돌면서 max 값을 구해서 제곱하면 답이 나옴
 * */
import java.util.*;
class Solution {
    public int solution(int [][]board){
        int row = board.length; // 행
        int col = board[0].length; // 열

        if(row==1|| col==1)
            return 1;

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(board[i][j]==1){
                    if(board[i-1][j-1]>=1 && board[i-1][j]>=1 && board[i][j-1]>=1){
                        board[i][j]=Math.min(Math.min(board[i-1][j],board[i][j-1]),board[i-1][j-1])+1;
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(max<=board[i][j]){
                    max=board[i][j];
                }
            }
        }
        return max*max;
    }
}