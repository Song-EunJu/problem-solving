import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;


public class baekjoon1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<test;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ArrayList<Element> list = new ArrayList();
            for(int j=0;j<n;j++){
                list.add(new Element(j,Integer.parseInt(st.nextToken())));
            }
            sb.append(cal(list, m)+"\n");
        }
        System.out.println(sb);
    }

    static class Element {
        int pos;
        int priority;

        public Element(int pos, int priority){
            this.pos=pos;
            this.priority=priority;
        }
    }

    static int cal(ArrayList<Element> list, int m){
        int cnt = 0;
        while(!list.isEmpty()) {
            int temp = -1;

            // 자신보다 큰 요소가 있는 지 확인
            for (int i = 1; i < list.size(); i++) {
                if (list.get(0).priority < list.get(i).priority) {
                    int tempPos = list.get(0).pos;
                    int tempPriority = list.get(0).priority;
                    list.remove(0);
                    list.add(new Element(tempPos, tempPriority));
                    temp++; // 큰 요소가 있는 경우 temp 값 변경
                    break;
                }
            }

            // temp 변경이 안된 것 = 큰 요소가 없다는 것 = 자기 자신을 인쇄해도 된다는 것
            if (temp == -1) {
                cnt++;
                if(list.get(0).pos == m)
                    return cnt;
                list.remove(0);
            }
        }
        return cnt;
    }
}
