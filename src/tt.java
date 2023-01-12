import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            // 배열 초기화
            int arr[][] = new int[9][9];
            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            // 가로 + 세로 체크
            for (int j = 0; j < 9; j++) {
                int sumCol = 0;
                int sumRow = 0;
                for (int k = 0; k < 9; k++) {
                    sumCol += arr[k][j]; // 열
                    sumRow += arr[j][k]; // 행
                }
                if (sumCol != 45 || sumRow != 45) {
                    cnt++; // 겹치는 숫자가 있는 경우
                    System.out.println("#" + (i + 1) + " 0");
                    break;
                }
            }

            //  위와 같이 겹치는 숫자가 없을 경우 1을 정답으로 출력하고
            //  겹치는 숫자가 있는 경우 0 을 출력

            if(cnt != 0) // 겹치는 숫자가 있는 경우 이미 출력했으니까 끝
                continue;

            cnt = 0;
            // 네모 돌면서
            for (int k = 0; k < 9; k += 3) {
                for (int h = k; h < k + 3; h++) {
                    for (int x = 0; x < 9; x += 3) {
                        int sum = 0;
                        for (int j = x; j < x + 3; j++) {
                            sum += arr[h][j];
                        }
                        if (sum != 45) {
                            cnt++;
                            System.out.println("#" + (i + 1) + " 0");
                            continue;
                        }
                    }
                }
            }

            if(cnt == 0) // 겹치는 숫자가 없는 경우
                System.out.println("#"+(i+1)+" 1");
        }
    }
}