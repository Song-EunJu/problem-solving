/* 풀지 못함 ...
[문제 요약]
- 두 사람의 좋아하는 정도의 합이 가장 크도록 케이크 분배
- 연속된 조각으로만 분배
- 둘다 다른 부분을 줘야 함
- 존과 클로이의 합계의 최댓값이어야 함
*/
import java.util.*;
import java.io.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 수행횟수
        for(int test=0;test<T;test++){
            N = Integer.parseInt(br.readLine()); // 케이크 조각 수
            int john[] = new int[N];
            int chloe[] = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                int n = Integer.parseInt(st.nextToken());
                // 좋아하는 정도에 대해서 음수를 포함했을 때 각 배열의 인덱스까지의 최댓값이 담기도록 배열 생성
                if(i == 0) // 첫번째 인덱스는 그대로 저장
                    john[i] = n;
                else // 나머지 인덱스는 (이전인덱스와 합산한 값, 현재 값) 을 비교하여 max 값을 저장
                    john[i] = Math.max(john[i-1] + n, n);
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                int n = Integer.parseInt(st.nextToken());
                if(i == 0)
                    chloe[i] = n;
                else
                    chloe[i] = Math.max(chloe[i-1] + n, n);
            }

            // ** 구간이 안겹치게 클로이, 존의 영역을 어떻게 구해야 할 지 모르겠다..
            sb.append("#"+(test+1)+" \n");
        }
        System.out.print(sb);
    }
}