//public class sw1859 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//
//        // 배열에서 자기자신보다 큰 원소가 무엇인지 찾기!!!
//        for(int i=0;i<T;i++) {
//            int N = Integer.parseInt(br.readLine());
//            int arr[] = new int[N];
//            int number[] = new int[N];
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                arr[j] = Integer.parseInt(st.nextToken());
//            }
//
//            for (int j = 0; j < N; j++) {
//                int max = arr[j];
//                for (int k = j + 1; k < N; k++) {
//                    if (max < arr[k])
//                        max = arr[k];
//                }
//                number[j] = max;
//            }
//            long sum = 0;
//            for (int j = 0; j < N; j++) {
//                int n = (number[j] == 0) ? 0 : number[j] - arr[j];
//                sum += n;
//            }
//            sb.append("#" + (i + 1) + " " + sum + "\n");
//        }
//        System.out.println(sb);
//
//    }
//}

/**
 * 기존)
 * 위의 방식으로 풀었을 때는 시간초과
 * 이중 for문을 이용해서 각 자리에서의 숫자보다 큰 수를 비교하니까 시간초과가 날 수밖에 없었음 -> O(n^2)
 *
 * 변경)
 * 뒤에서부터 풀었을 때, 각 배열 원소가 max 값보다 작은 경우에만 sum 에 더해주면서 차익을 계산해줄 수 있다.
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1859 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 배열에서 자기자신보다 큰 원소가 무엇인지 찾기!!!
        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            int max = 0;
            // 맨 뒤에서부터 max 값보다 작은 경우에만 매매값의 차익을 얻을 수 있음
            for(int j=N-1;j>=0;j--){
                if(max < arr[j])
                    max = arr[j];
                else{
                    sum += max-arr[j];
                }
            }
            sb.append("#" + (i + 1) + " " + sum + "\n");
        }
        System.out.println(sb);
    }
}
