import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사칙연산 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static char[] elements;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test=0;test<10;test++) {
            N = Integer.parseInt(br.readLine()); // 정점 개수
            StringTokenizer st;
            elements = new char[N+1];

            for(int j=0;j<N;j++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                elements[n] = st.nextToken().charAt(0);
            }

            // 노드가 홀수이면 true + 리프노드가 모두 숫자 + n/2번째 노드까지는 모두 연산자
            if(checkOdd() && checkLeafIsNumber() && checkOp())
                sb.append("#" + (test + 1) + " 1");
            else
                sb.append("#" + (test + 1) + " 0");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean checkOdd() {
        if (N % 2 == 0)
            return false;
        return true;
    }

    private static boolean checkLeafIsNumber() {
        int sum = 1;
        int cnt = 0; // N보다 작은 2의 제곱수까지 몇번 돌아야 하는지
        while(sum<=N){
            sum*=2;
            cnt++;
        }

        int start = (int)Math.pow(2, cnt);
        int end = N;
        for(int i=start;i<=end;i++){
            if(elements[i]=='+' || elements[i]=='-' || elements[i]=='*' || elements[i]=='/')
                return false;
        }
        return true;
    }

    private static boolean checkOp() {
        // 3. 리프노드가 아닌 애들은 n/2 일때까지 연산자
        for(int i=1;i<=N/2;i++){
            if(elements[i]!='+' && elements[i]!='-' && elements[i]!='*' && elements[i]!='/')
                return false;
        }
        return true;
    }
}
