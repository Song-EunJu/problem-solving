package swe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창용마을무리의개수 {
    static int parents[];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 사람 수
            int m = Integer.parseInt(st.nextToken()); // 관계의 개수
            makeSet();

            sb.append("#"+(t+1)+" ");
            for(int j=0;j<m;j++) { // 각각의 연산이 주어짐
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            int cnt = 0;
            for(int k=1;k<=n;k++) {
                if(parents[k] < 0)
                    cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }

    public static void makeSet() {
        parents = new int[n+1];

        for(int i=0;i<=n;i++) {
            parents[i] = -1;
        }
    }

    public static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if(A != B) {// 부모가 같지 않다면
            parents[A] += parents[B];
            parents[B] = A;
        }
    }

    public static int find(int num) {
        if(0 > parents[num])
            return num; // 내가 보스라는 것

        // 내가 보스가 아니라면, 나의 부모
        return parents[num] = find(parents[num]);
    }
}