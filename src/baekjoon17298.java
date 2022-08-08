import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * // 시간 초과
 * -1이 나오는 경우
 * 1) 자신의 오른쪽에 큰 수가 없는 경우
 * 2) 자신이 오른쪽에 어떤 수도 존재하지 않는 경우
 *
 * 자신보다 큰 수가 나오는 경우 무조건 걔로 설정하면 됨.
 *
 * 이중 for문을 도는 경우 O(n^2)
 **/
public class baekjoon17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int cnt=0;
        for(int i=0;i<n;i++){
            int out = stack.push(arr[i]);

            if(cnt==0)
                sb.append("-1 ");
            cnt=0;
        }
        System.out.print(sb);
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int n = Integer.parseInt(br.readLine());
//        Stack<Integer> stack = new Stack<>();
//        int[] arr = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//        for(int i=0;i<n;i++) // 스택은 배열 뒤에서 부터 넣어야 함
//            stack.push(arr[n-(i+1)]);
//        int cnt=0;
//        for(int i=0;i<n;i++){
//            int out = stack.pop();
//            for(int j=stack.size()-1;j>=0;j--){ // 스택 밑바닥부터 접근
//                if(out<stack.get(j)){
//                    sb.append(stack.get(j)+" ");
//                    cnt++;
//                    break;
//                }
//            }
//            if(cnt==0)
//                sb.append("-1 ");
//            cnt=0;
//        }
//        System.out.print(sb);
//    }

}
