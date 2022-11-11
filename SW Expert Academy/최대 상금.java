import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 목표 : 교환하는 횟수에 따라 가장 큰 수를 구하기
 * 접근 : 교환횟수를 다 쓰면서 나올 수 있는 수 중에 가장 큰 수를 구하자
 * 교환횟수를 다 쓰게 하기 위해서는 dfs 가 필요하다.
 *
 */

// 정해진 횟수만큼 숫자판을 교환했을 때 받을 수 있는 가장 큰 금액
public class test {
    static StringBuilder sb;
    static int exchange;
    static int max;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            exchange = Integer.parseInt(st.nextToken());
            arr = new int[String.valueOf(number).length()];

            for(int j=0;j<arr.length;j++){
                int num = String.valueOf(number).charAt(j)-'0';
                arr[j] = num;
            }

            // 교환횟수가 자릿수보다 큰 경우라면, 그냥 자릿수만큼으로 초기화
            // 자릿수만큼의 길이면 전부 옮길 수 있음
            if(arr.length<exchange)
                exchange = arr.length;

            dfs(0, 0);
            sb.append("#"+(i+1)+" "+max+"\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int k, int count){
        String str = "";

        if(count == exchange){ // 교환횟수를 다 채웠을 때
            for(int i=0;i<arr.length;i++){
                str+=arr[i];
            }

            int number = Integer.parseInt(str);
            if(max < number)
                max = number;
            return;
        }

        for(int i=k;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                /**
                 * 원래 이부분에 if(arr[i] <= arr[j]) 이게 있었는데, 이렇게 되면
                 * 21 1 인 경우 값을 바꾸지 않고 0 으로 출력되는 오류가 있었음
                 * 따라서 그냥 모든 경우의 수를 다 구해야 함
                 */
                swap(i, j);
                dfs(i, count+1);
                swap(i, j);
            }
        }
    }
    public static void swap(int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
