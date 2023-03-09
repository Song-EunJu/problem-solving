import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 배열 A의 값 = 각 행에 있는 모든 수의 합 중 최소
// 회전 연산의 순서도 정해야 하는 건가
public class baekjoon17406 {
    static int arr[][];
    static int change[][];
    static int orders[]; // 숫자 순서 저장하는 배열
    static boolean visited[]; // 숫자 사용 여부
    static int N, M, K;
    static int rotate[][]; // 회전 연산 정보
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 회전 연산 횟수
        orders = new int[K];
        visited = new boolean[K];
        arr = new int[N+1][M+1]; // 원본 배열
        rotate = new int[K][3];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++)
                rotate[i][j] = Integer.parseInt(st.nextToken());
        }

        // 1. 회전 연산 개수 순서정하기
        order(0);

        /**
         * 3C3 순열이라고 생각하며 연산 순서 정하면 됨
         * 1,2,3
         * 1,3,2
         * 2,1,3
         * 2,3,1
         * 3,1,2
         * 3,2,1
         */
        System.out.println(min);
    }

    private static void order(int cnt) {
        if(cnt == K){ // 2. 회전 연산 순서를 정했으면,
            change = new int[N+1][M+1]; // 원본 배열을 복사한다
            for(int i=0;i<N+1;i++){
                change[i] = Arrays.copyOf(arr[i], arr[i].length);
            }

            // 회전 연산 순서에 따라 turn 하는 연산
            for(int i=0;i<orders.length;i++){
               int num = orders[i];
               int r = rotate[num][0];
               int c = rotate[num][1];
               int s = rotate[num][2];
               turn(r-s, c-s, r+s, c+s);
            }

            // 순서에 맞게 다 돌리고 나서 배열의 값 최소 값 업데이트
            min = Math.min(min, findMin());
            return;
        }

        for(int i=0;i<K;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            orders[i] = cnt;
            order(cnt+1);
            visited[i] = false;
        }
    }

    // 배열의 최소값 구하는 코드
    private static int findMin() {
        int rowMin = Integer.MAX_VALUE;
        for(int i=1;i<change.length;i++){
            int sum = 0;
            for(int j=1;j<change[i].length;j++){
                sum += change[i][j];
            }
            rowMin = Math.min(sum, rowMin);
        }
        return rowMin;
    }

    public static void turn(int startY, int startX, int endY, int endX){
        while(startY!=endY && startX!=endX) {

            int temp = change[startY][endX];
            for (int i = endX; i > startX; i--) {
                change[startY][i] = change[startY][i - 1];
            }

            int next = change[endY][endX];
            for (int i = endY; i > startY + 1; i--) {
                change[i][endX] = change[i - 1][endX];
            }
            change[startY + 1][endX] = temp;

            temp = change[endY][startX];
            for (int i = startX; i < endX - 1; i++) {
                change[endY][i] = change[endY][i + 1];
            }
            change[endY][endX - 1] = next;

            for (int i = startY; i < endY - 1; i++) {
                change[i][startX] = change[i + 1][startX];
            }
            change[endY - 1][startX] = temp;

            // 테두리 하나씩 들어가면서 모든 테두리를 돌려야 하니까 다음 테두리 좌표로 만들어주기 위해
            startY++;
            startX++;
            endY--;
            endX--;
        }
    }
}
