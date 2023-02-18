import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon3040 {
    static int arr[];
    static int selected[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        selected = new int[7];

        for(int i=0;i<9;i++)
            arr[i] = Integer.parseInt(br.readLine());

        combination(0, 0, 0);
    }

    public static void combination(int num, int start, int sum){
        if(num == 7){
            if(sum == 100){
                for(int i=0;i<7;i++)
                    System.out.println(selected[i]);
            }
            return;
        }

        for(int i=start;i<9;i++){
            selected[num] = arr[i];
            combination(num+1, i+1, sum + arr[i]);
        }
    }
}
