import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int alphabet[] = new int[26];
        String str = br.readLine();
        for(int i=0;i<str.length();i++){
            alphabet[str.charAt(i)-97]++;
        }
        for(int i=0;i<26;i++){
            System.out.print(alphabet[i]+" ");
        }
    }
}
