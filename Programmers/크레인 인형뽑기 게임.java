import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(); //몇개가 0이 들어올지 모르니까 arraylist 로 선언

        for(int i=0;i<board.length;i++){
            ArrayList<Integer> li = new ArrayList<Integer>();
            for(int j=0;j<board[i].length;j++){
                int num = board[j][i];
                if(num!=0){
                    li.add(num);
                }
            }
            list.add(li);
        }

        ArrayList<Integer> doll = new ArrayList<Integer>();

        for(int i=0;i<moves.length;i++){
            if(list.get(moves[i]-1).size()!=0){
                int num = list.get(moves[i]-1).remove(0);
                doll.add(num); // 해당 바구니에 있는 첫번째 애를 꺼내서 삭제하면서 뽑은 인형에 넣기
            }
            if(doll.size()>1){
                if(doll.get(doll.size()-2)==doll.get(doll.size()-1)){
                    doll.remove(doll.size()-2);
                    doll.remove(doll.size()-1);
                    answer+=2;
                }
            }
        }
        return answer;
    }
}