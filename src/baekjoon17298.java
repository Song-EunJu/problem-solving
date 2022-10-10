import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

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
        int[] numbers = new int[n];
        int[] answer = new int[n];
        Arrays.fill(answer, -1); // 모든 수의 오큰수가 없다고 가정하고 시작

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[0]); // 첫 원소는 스택에 넣어두고 시작

        for(int i=1;i<n;i++){
            int idx=i-1; // answer에 채워줄 인덱스는 지금 뽑은거보다 1씩 작아야 함
            while(!stack.isEmpty()){ // 현재 넣을 애랑 지금 스택에 들어가있는(=자기보다 큰수 못찾은) 애들을 비교하기 위해서 while문 돈다
                int num = stack.peek();
                if(numbers[i]>num) { // 스택에 들어가있는 애를 꺼내서 현재 넣을 애랑 비교해서 현재 넣을 애가 크면
                    // answer 배열 원소값이 -1인 애를 찾아 떠남 (이미 큰 수 찾아서 초기화한 애들은 건들면 안되니까)
                    while(answer[idx]!=-1){
                        idx--;
                    }
                    // 큰수를 못찾고 슬퍼하던 원소를 찾은 경우 answer 배열 값을 업데이트시켜주고 스택에서 삭제
                    answer[idx] = numbers[i];
                    stack.pop();
                }
                else // 스택에 있던 수가 더 큰 경우는 break
                    break;
            }
            stack.push(numbers[i]);
        }

        // 최종 결과물
        for(int i=0;i<answer.length;i++)
            sb.append(answer[i]+" ");

        System.out.print(sb);
    }
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
//}
