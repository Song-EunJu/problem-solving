import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon14226 {
    static boolean visit[][];
    static class State {
        int display;
        int clipboard;
        int time;

        public State(int display, int clipboard, int time) {
            this.display = display;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 만들 이모티콘 개수
        visit = new boolean[1001][1001];
        bfs(S);
    }

    private static void bfs(int s) {
        Queue<State> q = new ArrayDeque<>();
        // 처음 상태 : 화면에 이모티콘 1개 있는 상태
        q.add(new State(1, 0, 0));
        visit[1][0] = true; // (화면 이모지, 클립보드 이모지)

        while(!q.isEmpty()){
            State cur = q.poll();
            int curDisplay = cur.display;
            int curClipBoard = cur.clipboard;
            int curTime = cur.time;

            if(curDisplay == s) {
                System.out.println(cur.time);
                break;
            }
            // 1번 연산 : 클립보드 = 화면
            if(curDisplay != 0 && !visit[curDisplay][curDisplay]) {
                q.add(new State(curDisplay, curDisplay, curTime+1));
                visit[curDisplay][curDisplay] = true;
            }

            // 2번 연산 : 화면 += 클립보드
            if(curClipBoard != 0 && (curDisplay + curClipBoard <= s)
                    && !visit[curDisplay + curClipBoard][curClipBoard]) {
                q.add(new State(curDisplay + curClipBoard, curClipBoard, curTime+1));
                visit[curDisplay + curClipBoard][curClipBoard] = true;
            }

            // 3번 연산 : 화면 -= 1
            if(curDisplay >= 1 && !visit[curDisplay-1][curClipBoard]) {
                q.add(new State(curDisplay-1, curClipBoard, curTime+1));
                visit[curDisplay-1][curClipBoard] = true;
            }
        }
    }
}
