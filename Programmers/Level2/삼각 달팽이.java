class Solution {
    public int[] solution(int n) {
        int[][] matrix = new int[n][n];
        int[] answer = new int[n*(n+1)/2];

        int x=0,y=0;
        int cnt = 1;
        matrix[0][0] = 1;

        while (cnt!=n*(n+1)/2) {
            // 왼쪽 - 위에서 아래로
            while (x+1<n && matrix[x+1][y]==0) {
                matrix[++x][y] = ++cnt;
            }

            // 아래 - 왼쪽에서 오른쪽으로
            while (y+1<n && matrix[x][y+1]==0) {
                matrix[x][++y] = ++cnt;
            }

            // 오른쪽 아래에서 대각선 위로
            while (y-1 >0 && x-1>0 && matrix[x-1][y-1]==0) {
                matrix[--x][--y] = ++cnt;
            }
        }
        int k=0;
        for(int i=0;i<matrix.length;i++) {
            for (int j= 0;j<=i;j++) {
                answer[k++] = matrix[i][j];
            }
        }
        return answer;
    }
}