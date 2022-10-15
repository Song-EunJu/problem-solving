import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * for문을 돌면서, 알파벳에 방문처리를 한다.
 * 방문처리한 알파벳 개수가 L개가 된 경우 (=depth가 L이 된 경우)
 * L개가 된 경우에 오름차순 정렬해서 sb.append 에 넣기!
 * */
public class baekjoon1759 {
    static int L;
    static int C;
    static Character alphabet[];
    static List<Character> choosed;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[C];
        alphabet = new Character[C];
        choosed = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<C;i++){
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet); // 배열 자체를 정렬하고 시작하면, 각 문자를 붙인 문자열을 따로 정렬안해도 됨!!
        backtracking(0,0);
    }

    public static void backtracking(int depth, int start){
        if(depth == L){
            int a = 0; // 모음
            int b = 0; // 자음
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<C;i++){
                if(visited[i]){ // 방문한 경우
                    char ch = alphabet[i];
                    sb.append(ch);
                    if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
                        a++;
                    else
                        b++;
                }
            }
            if(a>=1 && b>=2)
                System.out.println(sb);
            return;
        }

        for(int i=start;i<C;i++){
            if(!visited[i]){ // 방문하지 않은 경우
                visited[i] = true;
                backtracking(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
