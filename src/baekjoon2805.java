import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int tree[] = new int[n];
        st = new StringTokenizer(br.readLine());
        long left = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }
        // 적어도 M미터의 나무를 집에 가져가기 위해 절단기에 설정가능한 높이의 최댓값!

        long min = 0;
        long right = max-1;
        /**
         * left=0 바닥부터, right=제일 큰 나무높이-1 에서 범위를 좁혀가면서
         * 절단기에 설정가능한 높이 범위를 찾아간다
         * */
        while(left<=right){
            long mid = (left+right)/2;
            long sum = 0;
            for(int i=0;i<tree.length;i++){
                if(tree[i] > mid)
                    sum += tree[i]-mid;
            }

            /** 적어도 M미터의 나무를 집에 가져갔기 때문에 그때의 최댓값을 구하는 것 */
            if(sum >= m) {
                min = Math.max(mid, min);
                left = mid+1;
            }
            else if(sum < m)
                right = mid-1;
        }
        System.out.print(min);
    }
}
