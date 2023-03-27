import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int start = 0;
        int end = str.length()-1;
        boolean flag = true;
        while(start < end){
            if (str.charAt(start) != str.charAt(end)) {
                System.out.println(0);
                flag = false;
                break;
            }
            start++;
            end--;
        }
        if(flag)
            System.out.println(1);
    }
}
