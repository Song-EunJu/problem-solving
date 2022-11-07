import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 기차의 수
        int M = Integer.parseInt(st.nextToken()); // 명령의 수

        int train[][] = new int[N+1][21];

        for (int k=0;k<M;k++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken()); // 명령문
            int i = Integer.parseInt(st.nextToken()); // i번째 기차

            if (command <= 2) {
                int x = Integer.parseInt(st.nextToken());
                if (command == 1)
                    train[i][x] = 1;
                else if (command == 2)  // i번째 기차 x번째 좌석의 사람 하차
                    train[i][x] = 0;
            }
            else {
                /**
                 * 이 부분 for문에서 j=2;j<20 이런식으로 아래서부터 위로 올라가는 식으로 했는데,
                 * 이러면은 0 1 1 0 인 경우에 0 1 1 1 이렇게 1로 다 채워지는 문제가 생김
                 * 따라서 위에서부터 아래로 내려오면서 덮여쓰여지지 않게 해야 함 */
                if (command == 3) { // 한칸씩 뒤로
                    for (int j=20;j>=2;j--){
                        train[i][j] = train[i][j-1];
                    }
                    train[i][1] = 0;
                } else if (command == 4) { // 한칸씩 앞으로
                    for (int j=2;j<=20;j++) {
                        train[i][j-1] = train[i][j];
                    }
                    train[i][20]=0;
                }
            }
        }

        // 기차의 상태가 중복되지 않도록 hashset에 넣어서 계산
        HashSet<String> hashSet = new LinkedHashSet<>();
        StringBuilder sb;
        for(int i=1;i<=N;i++) {
            sb = new StringBuilder();
            for (int j=1;j<=20;j++) {
                sb.append(train[i][j]);
            }
            hashSet.add(sb.toString());
        }
        System.out.println(hashSet.size()); // 중복이 안되는 상태만 hashSet에 들어감
    }
}

