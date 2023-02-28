import java.util.Arrays;

public class testt {
    static int N;
    static int[] parents;

    static void makeSet() { // 모든 원소를 각각의 단위집합으로 만든다 (결국 크기가 1인 집합)
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = -1; // 자기자신을 자신의 집합의 대표자로 -1
        }
    }

    static int findSet(int a) {
        if (0 > parents[a])
            return a; // 자기 자신이 짱인 거임

        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot)
            return false; // 이미 같은 집합

        parents[aRoot] += parents[bRoot];
        // 집합이 몇개인지 알려면 음수인거의 개수, 음수인거 절댓값씌우면 집합의 개수
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) {
        N = 5;
        makeSet();
        System.out.println(Arrays.toString(parents));
        System.out.println(union(0, 1));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(2, 1));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(3, 2));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(4, 3));
        System.out.println(Arrays.toString(parents));

        System.out.println("=======================");
        System.out.println(findSet(4));
        System.out.println(Arrays.toString(parents));
        System.out.println(findSet(3));
        System.out.println(Arrays.toString(parents));
        System.out.println(findSet(2));
        System.out.println(Arrays.toString(parents));
        System.out.println(findSet(1));
        System.out.println(Arrays.toString(parents));
        System.out.println(findSet(0));
        System.out.println(Arrays.toString(parents));

    }
}