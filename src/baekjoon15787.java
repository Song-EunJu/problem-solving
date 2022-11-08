//public class baekjoon15787 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken()); // 기차의 수
//        int M = Integer.parseInt(st.nextToken()); // 명령의 수
//
//        int train[][] = new int[N+1][21];
//
//        for (int k=0;k<M;k++) {
//            st = new StringTokenizer(br.readLine());
//            int command = Integer.parseInt(st.nextToken()); // 명령문
//            int i = Integer.parseInt(st.nextToken()); // i번째 기차
//
//            if (command <= 2) {
//                int x = Integer.parseInt(st.nextToken());
//                if (command == 1)
//                    train[i][x] = 1;
//                else if (command == 2)  // i번째 기차 x번째 좌석의 사람 하차
//                    train[i][x] = 0;
//            }
//            else {
//                /**
//                 * 이 부분 for문에서 j=2;j<20 이런식으로 아래서부터 위로 올라가는 식으로 했는데,
//                 * 이러면은 0 1 1 0 인 경우에 0 1 1 1 이렇게 1로 다 채워지는 문제가 생김
//                 * 따라서 위에서부터 아래로 내려오면서 덮여쓰여지지 않게 해야 함 */
//                if (command == 3) { // 한칸씩 뒤로
//                    for (int j=20;j>=2;j--){
//                        train[i][j] = train[i][j-1];
//                    }
//                    train[i][1] = 0;
//                } else if (command == 4) { // 한칸씩 앞으로
//                    for (int j=2;j<=20;j++) {
//                        train[i][j-1] = train[i][j];
//                    }
//                    train[i][20]=0;
//                }
//            }
//        }
//
//        // 기차의 상태가 중복되지 않도록 hashset에 넣어서 계산
//        HashSet<String> hashSet = new LinkedHashSet<>();
//        StringBuilder sb;
//        for(int i=1;i<=N;i++) {
//            sb = new StringBuilder();
//            for (int j=1;j<=20;j++) {
//                sb.append(train[i][j]);
//            }
//            hashSet.add(sb.toString());
//        }
//        System.out.println(hashSet.size()); // 중복이 안되는 상태만 hashSet에 들어감
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class baekjoon15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 기차의 수
        int M = Integer.parseInt(st.nextToken()); // 명령의 수

        int train[] = new int[N+1];
        for (int k=0;k<M;k++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken()); // 명령문
            int i = Integer.parseInt(st.nextToken()); // i번째 기차

            if (command <= 2) {
                int x = Integer.parseInt(st.nextToken());
                if (command == 1) // 사람을 태우기
                    train[i] |= 1<<x;
                else if (command == 2)  // 사람을 내리게 하기
                    train[i] &= ~(1<<x);
                /** 사람을 태운거의 반대를 bit 연산자로 만든 후 교집합 구하기 */
            }
            else {
                if (command == 3) {// 한칸씩 뒤로
                    train[i] <<= 1; // 1.
                    train[i] &= ((1<<21)-1); // 2.
                    /**
                     [1]
                         0 00000 01010 01111 10000 이런식으로 된거를 1칸씩 미니까
                        00 00000 10100 11111 00000 이렇게 돼서 22칸이 되니까 밀린 값도 없애줘야 함

                     [2]
                         1<<21 인 경우)
                         10 00000 00000 00000 00000
                         (1<<21)-1 인 경우)
                          1 11111 11111 11111 11111
                         &
                         00 00000 10100 11111 00000
                         =
                         0 00000 10100 11111 00000 (사이즈 다시 21칸으로!)
                     */
                }
                else if (command == 4) {// 한칸씩 앞으로
                    train[i] >>= 1; // 1.
                    train[i] &= ~1; // 첫번째 자리가 0으로 고정되어 있어야 하므로
                    /** ~1 은 0이 아니라 0000001 을 뒤집은 1111110 이 된다.
                         0 00000 01010 01111 10010 이런식으로 된거를 1칸씩 미니까
                           00000 00010 10111 11001 이렇게 됨
                        첫번째 자리가 공석이기 때문에 저 1을 없애줘야 함
                        따라서 ~1로 1111110 이런식으로 바꿔서 & 로 덮어씌우면 1을 없앨 수 있음
                            */
                }
            }
        }

        // 기차의 상태가 중복되지 않도록 hashset에 넣어서 계산
        HashSet<Integer> hashSet = new LinkedHashSet<>();
        for(int i=1;i<=N;i++)
            hashSet.add(train[i]);
        System.out.println(hashSet.size()); // 중복이 안되는 상태만 hashSet에 들어감
    }
}
