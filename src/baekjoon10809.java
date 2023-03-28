import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        int alphabet[] = new int[26];
        Arrays.fill(alphabet, -1);

        for(int i=0;i<s.length();i++){
            alphabet[s.charAt(i)-97] = s.indexOf(s.charAt(i));
        }

        for(int i=0;i<26;i++)
            sb.append(alphabet[i]+" ");
        System.out.println(sb);
    }
}