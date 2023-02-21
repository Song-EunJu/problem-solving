import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1074 {
	static int r, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken()); // 행번호
		c = Integer.parseInt(st.nextToken()); // 열번호

		divide((int) Math.pow(2, N), 0, 0, 0);
	}

    /**
     *  1. 처음 접근 : divide 함수 4개 호출해서 모든 곳을 돌면서 배열에 채워넣고 배열 인덱스 리턴
     *  -> 2^15 * 2^15 배열크기가 되니까 백퍼 메모리 초과 나겠다
     *  2. 배열 말고 그냥 cnt 를 늘려가면서 divide 함수 4개 호출하자
     *  -> 응 시간초과남
     *  3. 4분면으로 나눠서 i, j가 속하는 사분면만 탐방하자
     *  -> 인덱스 관리 어떻게 하는 지 몰라서 망함
     * */
	private static void divide(int n, int i, int j, int cnt) {
        if(n == 1) {
            System.out.println(cnt);
            return;
        }
        int len = n/2;
        // 배열 한 변의 길이를 반으로 나눈 것을 활용하여 각 사분면의 시작점의 cnt 값을 구할 수 있고
        // 쪼갤 때마다 기존 cnt 에 더해가면서 계산해야 한다
		if(r >= i+len && c >= j+len)  // 4사분면
            divide(len, i+len, j+len, cnt+len*len*3);
        else if(r >= i+len && c < j+len) // 3사분면
            divide(len, i+len, j, cnt+len*len*2);
		else if(r < i+len && c >= j+len) // 2사분면
            divide(len, i, j+len, cnt+len*len);
        else // 1사분면
            divide(len, i, j, cnt);
	}
}