/*
    (4,3) (3,2) -> (4,2)
    (i,j) * (j,k) = (i,k) 이므로 이를 코드에 그대로 적용시킨다
*/
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int p = arr1.length;
        int q = arr1[0].length;
        int s = arr2[0].length;
        int[][] answer = new int[p][s];


        for(int i=0;i<p;i++){
            for(int k=0;k<s;k++){
                for(int j=0;j<q;j++){
                    answer[i][k]+=(arr1[i][j]*arr2[j][k]);
                }
            }
        }
        return answer;
    }
}