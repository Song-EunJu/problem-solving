import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N이 50만 이하이니까 배열에 담지 말고 그때그때 처리하자
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();
        // 첫번째 원소를 stack 에 넣기 위함
        int num = Integer.parseInt(st.nextToken());
        stack.push(new int[]{num, 1});
        sb.append(0 + " ");

        for (int i = 1; i < N; i++) {
            num = Integer.parseInt(st.nextToken());

            /**
             * stack 에 있는 탑보다 현재 탑의 높이가 높으면,
             * stack 에 있는 탑들은 어차피 가려져서 레이저를 못받으니까 pop 해버림
             */
            while (!stack.isEmpty() && stack.peek()[0] < num)
                stack.pop();

            /**
             * stack이 비어있지 않다면 , 현재 탑보다 높은 탑이 존재하는 것이니까
             * 해당 탑의 순서를 출력
             *
             * stack이 비어있다면,
             * */
            if(!stack.isEmpty())
                sb.append(stack.peek()[1] + " ");
            else
                sb.append(0 + " ");
            stack.push(new int[]{num,i+1});
        }
        System.out.println(sb);
    }
}