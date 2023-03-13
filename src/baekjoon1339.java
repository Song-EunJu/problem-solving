import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/** (알파벳, 알파벳 자릿수) 를 큐에 넣고, 알파벳 자릿수 큰 거부터 꺼내보자 -> 우선순위 큐 사용 */
class Alphabet{
    char alpha; // 알파벳
    int pos; // 자릿수
    int num; // 해당 알파벳이 몇번 나오는지
    /*
    * BC
    * AA
    * -> 이 예제 때문에 같은 자릿수더라도, 또 한번 더 나오는 애가 더 큰 값을 갖도록 해야한다는 생각을 하게 됨
    * */
    public Alphabet(char alpha, int pos, int num) {
        this.alpha = alpha;
        this.pos = pos;
        this.num = num;
    }
}
public class baekjoon1339 {
    static Queue<Alphabet> q;
    static String wordArray[];
    static boolean visit[];
    static int alphabet[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        q = new PriorityQueue<>((o1, o2) ->{
            if(o1.pos == o2.pos)
                return o2.num - o1.num;
            return o2.pos - o1.pos;
        });
        wordArray = new String[N]; // 단어 저장 배열
        visit = new boolean[26]; // 알파벳 방문처리 배열
        alphabet = new int[26]; // 알파벳 - 숫자 매핑 배열

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            wordArray[i] = br.readLine();
            char alphabets[] = wordArray[i].toCharArray();
            for(int j=0;j<alphabets.length;j++) {
                map.put(alphabets[j], map.getOrDefault(alphabets[j], 0) + 1);
            }
        }

        for(int i=0;i<N;i++){
            char alphabets[] = wordArray[i].toCharArray();
            for(int j=0;j<alphabets.length;j++) {
                q.add(new Alphabet(alphabets[j], alphabets.length - j, map.get(alphabets[j])));
            }
        }
        wordSum(); // 단어 - 숫자 매핑
        System.out.println(calc());
    }

    private static void wordSum() {
        int num = 9;
        while(!q.isEmpty()) {
            // 큐에서 꺼냈는데 방문처리가 되어있는 애면 버림 -> 이미 나온 숫자인데, 자릿수가 작은 애인 경우
            Alphabet cur = q.poll();
            char curAlpha = cur.alpha;
            if (visit[curAlpha-65])
                continue;
            visit[curAlpha-65] = true;
            alphabet[curAlpha-65] = num--;
        }
    }

    // 문자열에 있는 알파벳을 숫자로 바꾼 후 합을 구하는 함수
    private static long calc() {
        long sum = 0;
        for(int i=0;i<wordArray.length;i++){
            char words[] = wordArray[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<words.length;j++){
                sb.append(alphabet[words[j]-65]);
            }
            sum += Integer.valueOf(sb.toString());
        }
        return sum;
    }

}
