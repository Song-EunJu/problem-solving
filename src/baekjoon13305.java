import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 그리디 (탐욕): 선택의 순간에서 가장 최선의 것을 선정한다.
 * 현 위치에서 가장 최선의 선택? 다음꺼랑 비교할 수 밖에 없음.
 * 다음 주유소보다 가격이 싼 경우, 해당 가격으로 다음 주유소에서 주유할 양까지 넣어버린다.
 * 이걸 어떻게 끝까지 가져가냐? 주유 가격이 내림차순인 경우만 고려하여 거리와 곱해서 계산한다.
 * 다음 주유가격이 현 주유가격보다 비싸면 다음 주유가격을 현 주유 가격으로 바꿔치기~
 * */
public class baekjoon13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long price[] = new long[n];
        long dist[] = new long[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n-1;i++){
            dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            price[i] = Long.parseLong(st.nextToken());
        }

        long sum=0;
        for(int i=0;i<n-1;i++){
            if(price[i]<price[i+1])  // 가격이 내림차순인 경우의 연산
                price[i+1] = price[i];
            sum += price[i]*dist[i];
        }
        System.out.println(sum);
    }
}