import java.util.Scanner;

public class baekjoon11659_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();	// 높이
        int m = sc.nextInt();	// 너비
        int r = sc.nextInt();	// 회전 수
        int[][] map = new int[n][m];

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int line = Math.min(n, m) / 2;	// 회전시킬 라인의 수

        /**
         * 각각의 테두리를 순차적으로 돌면서 한자리씩 움직이기 -> 회전할 횟수만큼 돈다
         * R%num 연산이 불가능하다. num은 각 테두리마다 다른데, r 이 제일 바깥 for문에서 돌고 있기 때문에
         * */
        for(int i = 0 ; i < r ; i++) {	// 회전할 횟수만큼
            for(int j = 0 ; j < line ; j++) {	// 테두리하나씩 돌면서
                int temp = map[j][j];	// 첫번째 원소를 저장

                for(int k = j+1 ; k < m - j ; k++)	// 위쪽 라인 스와이핑 (왼쪽으로 스와이핑)
                    map[j][k-1] = map[j][k];

                for(int k = j+1 ; k < n - j ; k++)	// 오른쪽 라인 스와이핑 (위로 스와이핑)
                    map[k-1][m-j-1] = map[k][m-j-1];

                for(int k = m-2-j ; k >=j  ; k--)	// 아래쪽 라인 스와이핑 (오른쪽으로 스와이핑)
                    map[n-j-1][k+1] = map[n-j-1][k];

                for(int k = n-2-j ; k >= j ; k--)	// 왼쪽 라인 스와이핑 (아래로 스와이핑)
                    map[k+1][j] = map[k][j];

                map[j+1][j] = temp;
            }
        }


        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

}
