import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baekjoon10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int cnt=0; // k번 도는지 세기 위한 변수
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            if(cnt==k) // k번 for문이 돌면 종료
                break;
            int n = Integer.parseInt(br.readLine());
            if(n==0) {
                list.remove(i - 1); // 0이면 그 전 값을 지우고
                i-=2; // 인덱스를 2를 줄여야 다음 for문이 돌때 ++이 되면서 i-- 한 효과가 남
            }
            else
                list.add(n);
        }

        int sum=0;
        for(Integer el : list){
            sum+=el;
        }
        System.out.println(sum);
    }
}
