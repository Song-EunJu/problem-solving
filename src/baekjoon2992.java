import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2992 {
    static int[] num;
    static boolean[] visited;
    static int len;
    static int X;
    static String str = "";
    static int check = 0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        String str = String.valueOf(X);
        len = str.length(); // 숫자의 자릿수
        visited = new boolean[len];

        num = new int[len];
        for(int i=0;i<len;i++){
            num[i] = str.charAt(i)-'0';
        }
        permutation(0);
        System.out.println(check == 0 ? 0 : min);
    }

    public static void permutation(int cnt){
        if(cnt == len){
            int n = Integer.valueOf(str);
            if(n > X){
                check = 1;
                min = Math.min(min, n); // 큰 수 중에 작은 수 구하기
            }
            return;
        }

        for(int i=0;i<len;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            str += String.valueOf(num[i]);
            permutation(cnt+1);
            str = str.length() == 1 ? "" : str.substring(0, str.length()-1);
            visited[i] = false;
        }
    }

}
