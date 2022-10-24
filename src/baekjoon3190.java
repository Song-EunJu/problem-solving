import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon3190 {
    static int board[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 보드의 크기
        int k = Integer.parseInt(br.readLine()); // 사과의 개수
        board = new int[n+1][n+1];
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
        }
        int l = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
        for(int i=0;i<l;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            // 게임 시작시간으로부터 x초가 끝난 후에 왼 or 오로 90도 회전시킨다.
        }

    }
}


// 종료 조건 : 벽, 자기자신의 몸과 부딪히는 경우
