//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class baekjoon1715 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int arr[] = new int[N];
//        int sum = 0;
//        for(int i=0;i<N;i++)
//            arr[i] = Integer.parseInt(br.readLine());
//
//        Arrays.sort(arr);
//        int copy[] = Arrays.copyOf(arr, arr.length);
//        if(N%2 != 0) {
//            for (int i = 1; i < N; i++) {
//                arr[i] += arr[i - 1];
//                sum += arr[i];
//            }
//        }
//        else {
//            for (int i = 1; i < N; i++) {
//                arr[i] += arr[i - 1];
//                sum += arr[i];
//            }
//
//            int sum2 = 0;
//            int sum3 = 0;
//            for(int i=0;i<N/2;i++){
//                copy[i] += copy[(N-1)-i];
//                sum2 += copy[i];
//                if(i>=1){
//                    copy[i] += copy[i - 1];
//                    sum3 += copy[i];
//                }
//            }
//            System.out.println(Math.min(sum, sum2+sum3));
//            return;
//        }
//        System.out.println(sum);
//    }
//}

/**
 * 처음에 생각한 거는 1,2,3,4 이렇게 있으면 정렬하고 나서 앞에서부터 더해가는 게 베스트라고 생각했음.
 * 결국 A가 가장 작아야 한다고 생각했음.
 * 근데 2,2,3,3 의 같은 경우는 앞에서 부터 더하는 것보다 2+2, 3+3 을 먼저하고 4+6 하는 게 베스트임.
 * -> 결론적으로 리스트에서 가장 작은 2개를 먼저 더하고, 다시 큐에 넣은 상태에서 또 가장 작은 값끼리 먼저 더해가면서 합을 구하는게 최솟값
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class baekjoon1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<N;i++)
            q.add(Integer.parseInt(br.readLine()));

        int sum = 0;
        while(q.size()!=1){
            int a = q.poll();
            int b = q.poll();
            sum += (a+b);
            q.add(a+b);
        }
        System.out.println(sum);
    }
}
