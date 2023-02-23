//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class 무선충전 {
//    static int arr[][];
//    public static void main(String[] args) throws IOException {
//// 모든 사용자가 충전한 양의 합의 최댓값
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//        for(int test=0;test<T;test++){
//            arr = new int[11][11];
//            st = new StringTokenizer(br.readLine());
//            int M = Integer.parseInt(st.nextToken()); // 총 이동시간
//            int A = Integer.parseInt(st.nextToken()); // BC 의 개수
//
//            // 사용자의 이동정보 (M개의 숫자 = 매초마다 이동 방향)
//            Integer[] moveA = Arrays.stream(br.readLine().split(" ")).toArray(Integer[]::new);
//            Integer[] moveB = Arrays.stream(br.readLine().split(" ")).toArray(Integer[]::new);
//            for(int ap=0;ap<A;ap++){
//                st = new StringTokenizer(br.readLine());
//                int x = Integer.parseInt(st.nextToken()); // 5
//                int y = Integer.parseInt(st.nextToken()); // 2
//                arr[y][x];
//                int coverage = Integer.parseInt(st.nextToken()); // 충전범위
//                int pf = Integer.parseInt(st.nextToken()); // 성능
//            }
//
//
//            for(int i=0;i<M;i++){
//
//            }
//
//        }
//    }
//
//}
