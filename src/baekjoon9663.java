import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [시간초과 나는 코드]
 * - 대각선, 가로, 세로 겹치는 부분이 있는지 2차원 배열을 돌면서 탐색해야 하니까 시간 초과 발생
 */
//public class boj9663 {
//	static boolean[][] visit;
//	static int cnt = 0;
//	static int n;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		n = Integer.parseInt(br.readLine());
//		visit = new boolean[n][n];
//
//		for(int i=0;i<n;i++) { // 첫 줄 방문 여부 체크
//			visit[0][i] = true;
//			nqueen(0);
//			visit[0][i] = false;
//		}
//		System.out.println(cnt);
//	}
//
//	public static void nqueen(int num) {
//		if(num == n-1) {
//			cnt++;
//			return;
//		}
//
//		for(int i=0;i<n;i++){ // 한 행만 돌면서
//			if(promising(num+1, i)){// (0,0)의 상/하/대각선이 아닌 위치인지 확인
//				visit[num+1][i] = true;
//				nqueen(num+1);
//				visit[num+1][i] = false;
//			}
//		}
//	}
//
//	public static boolean promising(int y, int x) {
//		/* 유망한 노드라면 (말을 놓을 수 있다면) true 리턴
//		 = 즉, 놓은 노드랑 가로, 세로, 대각선에서 겹치지 않는다면 유망한 것 */
//
//		for(int i=0;i<y;i++) { // 이전 행까지만
//			for(int j=0;j<n;j++) {
//				if(visit[i][j] == true && Math.abs(y-i) == Math.abs(x-j)) // 대각선
//					return false;
//
//				if(visit[i][j] == true && y==i) // 세로
//					return false;
//
//				if(visit[i][j] == true && x==j) // 가로
//					return false;
//			}
//		}
//		return true;
//	}
//}

public class baekjoon9663 {
    static int number[];
    static int cnt = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        number = new int[n];
        nqueen(0);
        System.out.println(cnt);
    }

    public static void nqueen(int num) {
        if(num == n) {
            cnt++;
            return;
        }

        for(int i=0;i<n;i++){ // 한 행만 돌면서
            number[num] = i; // number[num] 에 값을 넣어도 promising 에서 걸리면 다음 말로 못넘어가니까 괜찮음
            if(promising(num)){ // num 은 행번호 number[num] 은 열번호
                nqueen(num+1);
            }
        }
    }

    public static boolean promising(int idx) {
        for(int i=0;i<idx;i++) {
            // 1. 열의 값이 같다는 건 세로가 동일하다는 것
            // 2. 대각선이 같다는 건 y좌표의 차, x좌표의 차가 동일하다는 것
            if(number[i] == number[idx]|| Math.abs(i-idx) == Math.abs(number[i]-number[idx]))
                return false;
        }
        return true;
    }
}