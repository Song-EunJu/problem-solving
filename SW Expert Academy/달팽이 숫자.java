public class javatest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int idx=0;idx<T;idx++){
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];
            int cnt = 1;

            int x=0, y=0; // 배열의 원소에 접근하는 x,y 좌표
            int temp = n; // 상하좌우 연산을 반복하면서 n의 값을 줄여나가기 위한 임시 변수
            int end = 0; // 반복문 종료 체크를 위한 변수

            // n이 짝수인 경우, 상하좌우 반복문 n/2번 실행
            // n이 홀수인 경우, 상하좌우 반복문 n/2번 실행 + 가운데 원소 채우기
            // ex. n=4인 경우
            while(end<=n/2){
                for(int i=x;i<x+(temp-1);i++)   // → 방향으로 temp-1 개 채우기 (0,0) (0,1) (0,2)
                    arr[y][i] = cnt++;
                x = x+temp-1; // x의 좌표를 3으로 변경

                // n이 홀수인 경우, 마지막으로 가운데 원소 채우고 반복문 종료
                if(n%2==1 && end == n/2){
                    arr[x][x] = cnt;
                    break;
                }

                for(int i=y;i<y+(temp-1);i++) // ↓ 방향으로 temp-1 개 채우기 (0,3) (1,3) (2,3)
                    arr[i][x] = cnt++;
                y = y+temp-1; // y의 좌표를 3으로 변경

                for(int i=x;i>x-(temp-1);i--)  // ← 방향으로 temp-1 개 채우기 (3,3) (3,2) (3,1)
                    arr[y][i] = cnt++;
                x = x-(temp-1); // x의 좌표를 0으로 변경

                for(int i=y;i>y-(temp-1);i--) // ↑ 방향으로 temp-1 개 채우기 (3,0) (2,0) (1,0)
                    arr[i][x] = cnt++;
                y = y-(temp-1); // y의 좌표를 0으로 변경

                temp-=2; // 다음 상하좌우 연산에서는 2개씩 줄여가기 위해서
                x++; y++; // (0,0) 지점에서 (1,1) 로 옮겨서 다시 연산을 시작하기 위해 x, y값 증가
                end++; // 상하좌우 반복문 1번 실행했으므로 변수값 증가
            }

            System.out.println("#"+(idx+1));
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}