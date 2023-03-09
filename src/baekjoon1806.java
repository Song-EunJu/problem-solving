//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class baekjoon1806 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken()); // 길이가 N 짜리 수열
//        int S = Integer.parseInt(st.nextToken()); // 합이 S 이상이 되어야 함
//        int arr[] = new int[N];
//        st = new StringTokenizer(br.readLine());
//        arr[0] = Integer.parseInt(st.nextToken());
//        for(int i=1;i<arr.length;i++) {
//            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
//        }
//
//        int start = 0;
//        int end = 1;
//        int min = Integer.MAX_VALUE;
//
//        while(start<=end && end<N){
//            if(start == 0){
//                if(arr[end]>=S){ // 합 이상이 되는 경우에는 end 값을 줄여본다 (start 가 고정이니까)
//                    min = Math.min(min, end+1);
//                    end--;
//                }
//                else // 합보다 작은 경우에는 start 값을 늘려준다. end 값을 늘릴 수도 있지만 조금 조금씩 움직여야 하니까
//                    start++;
//            }
//            else {
//                if(arr[end]-arr[start] >= S){ // 합 이상이 되는 경우 start 를 늘린다.
//                    min = Math.min(min, end-start);
//                    start++;
//                }
//                else // 합보다 작은 경우 end값을 늘린다.
//                    end++;
//            }
//        }
//        System.out.println(start+" "+end);
//        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
//    }
//}
// 90 몇 퍼에서 에러남

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 길이가 N 짜리 수열
        int S = Integer.parseInt(st.nextToken()); // 합이 S 이상이 되어야 함
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<arr.length;i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        int start = -1;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while(start< N && end<N){
            if(start == -1){
                if(arr[end]>=S){ // 합보다 큰 경우에는 이제 start 값을 늘림
                    min = Math.min(min, end+1);
                    start++;
                }
                else // 합보다 작은 경우에는 end 값을 늘린다 (처음 start 값 고정시키고 end만 이동시키기)
                    end++;
            }
            else {
                if(arr[end]-arr[start] >= S){ // 합 이상이 되는 경우 start 를 늘린다.
                    min = Math.min(min, end-start);
                    start++;
                }
                else // 합보다 작은 경우 end값을 늘린다.
                    end++;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
