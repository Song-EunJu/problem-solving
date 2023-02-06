import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon11729 {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 원판 개수
        hanoi(n, 1, 2, 3); // 원판 3 개를 장대1에서 장대3으로 장대2를 이용해서 옮기겠다.
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    public static void hanoi(int num, int start, int mid, int end) {
        if(num == 1) { // 원판이 1개인 순간 출력
            sb.append(start+" "+end+"\n");
            cnt++;
            return;
        }

        // 원판 num-1=2개를 장대1에서 장대2로, 장대3을 이용해서 옮기겠다
        hanoi(num-1, start, end, mid);

        // 원판 1개 (제일 큰 거)를 장대1에서 장대3으로, 장대2를 이용해서 옮기겠다
        hanoi(1, start, mid, end);

        // 원판 num-1=2개를 장대2에서 장대3으로, 장대1을 이용해서 옮기겠다
        hanoi(num-1, mid, start, end);
    }
}
