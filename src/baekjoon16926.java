import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon16926 {
    static int N, M, R;
    static int arr[][];
    static Queue<Integer> q;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로길이를 2로 나눈거만큼 도는 게 생김
        int tempM = M;
        int tempN = N;
        int tempI = 0, tempJ = 0;

        for(int t=0;t<N/2;t++) {
            q = new LinkedList<>();
            int i=tempI, j=tempJ;
            // 각 테두리의 숫자 개수 계산 M*2 + (N-2)*2
            int num = (M-2*t)*2 + (N-2*(t+1))*2;

            fillQueue(i, j, tempI, tempJ, tempN, tempM, num);
            rotate();
            fillArray(i, j, tempI, tempJ, tempN, tempM, num);

            // 다음 테두리의 최대 가로, 세로 값을 바꿔주기 위해서
            tempM--; tempN--;

            // 다음 테두리의 시작 인덱스를 바꿔주기 위해서
            tempI++; tempJ++;
        }

        print();
    }

    private static void print() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void rotate() {
        // R번 회전시키기 위해서 큐에서 빼내서 맨 뒤에 넣음
        for(int k=0;k<R;k++) {
            q.add(q.poll());
        }
    }

    private static void fillQueue(int i, int j, int tempI, int tempJ, int tempN, int tempM, int num) {
        int cnt = 0;
        while(cnt < num) { // 테두리에 있는 숫자 개수만큼 반복문을 돌면서
            if(i==tempI && j<tempM-1) // 오른쪽으로 가기
                q.add(arr[i][j++]);

            else if(i<tempN-1 && j==tempM-1)
                q.add(arr[i++][j]);

            else if(i==tempN-1 && j>tempJ)
                q.add(arr[i][j--]);

            else if(i>tempI && j==tempJ) {
                q.add(arr[i--][j]);
            }
            cnt++;
        }
    }

    private static void fillArray(int i, int j, int tempI, int tempJ, int tempN, int tempM, int num) {
        // 큐에 넣은 값들을 다시 배열에 채워 넣음
        int cnt = 0;
        while(cnt < num) { // 각 테두리 도는 횟수
            if(i==tempI && j<tempM-1) // 오른쪽으로 가기
                arr[i][j++]=q.poll();

            else if(i<tempN-1 && j==tempM-1) // 아래로 가기
                arr[i++][j]=q.poll();

            else if(i==tempN-1 && j>tempJ) // 왼쪽으로 가기
                arr[i][j--]=q.poll();

            else if(i>tempI && j==tempJ) { // 위로 가기
                arr[i--][j]=q.poll();
            }
            cnt++;
        }
    }
}