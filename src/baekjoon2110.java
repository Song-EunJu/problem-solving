import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리 최댓값을 구하여라
public class baekjoon2110 {
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        /** 구해야 하는 것 : 가장 인접한 두 공유기 사이의 최대 거리 */
        // 공유기를 설치할 거리 간격을 이분탐색한다! == 즉, 2씩 거리두기할건지, 3씩 거리두기할 건지를 이분탐색을 통해 줄여가는 것!
        int start = 1; // 설치할 가장 가까운 거리
        int end = arr[n-1]-arr[0]; // 설치할 가장 먼 거리

        while(start<=end){
            int mid = (start+end)/2;

            if(install(mid) < c) // 공유기 심었을 때 필요한 공유기보다 적은 경우 == 너무 간격이 넓은 경우
                end = mid-1;
            else
                start = mid+1;

        }
        System.out.print(end);

    }

    // mid
    public static int install(int dist){
        // 왜 첫번째 요소에는 무조건 공유기를 설치하는가 ??
        int before = arr[0];
        int cnt = 1;

        // 가장 인접한 두 공유기의 최대 틈을 구해야 함.
        for(int i=1;i<arr.length;i++){
            /**
             * 이전 공유기 설치 지점과 현재 지점의 차이가, 최대거리 가정한 값 mid보다 작은 경우
             * (최대거리 가정한 것이 틀렸단 뜻!) 한턴 쉬고 최대거리 가정한 값만큼의 거리가 나올 때 공유기를 심음
             *
             * 최대거리 가정한 값이 mid 보다 큰 경우에는 일단, 조건 자체는 만족하지만 해당 최대거리가 최솟값인지 알수가 없음
             * */
            if(arr[i]-before >= dist){
                cnt++;
                before = arr[i]; // 최대거리 가정한 값을 줄여야 함
            }
        }
        return cnt;
    }
}
