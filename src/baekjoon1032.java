import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class baekjoon1032 {
    // 공통부분 찾아내기?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
        }

        // 문자열의 길이를 돌면서, 모두 같은 알파벳인지 체크
        for (int i = 0; i < strs[0].length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < strs.length; j++) {
                set.add(strs[j].charAt(i));
            }
            if (set.size() == 1) {
                for(Character ch : set)
                    sb.append(ch);
            }
            else sb.append("?");
        }
        System.out.println(sb);
    }
}
