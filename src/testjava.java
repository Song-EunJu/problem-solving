import java.util.ArrayList;
import java.util.List;

public class testjava {
    static boolean visited[] = new boolean[4];
    static int point[] = new int[]{1,2,3,4};
    static List<Integer> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();

    public static void main(String[] args) {
        dfs(0);
    }

    public static void dfs(int n) {
        if (n == point.length - 1) {
            System.out.print(a.toString());
            System.out.println(b.toString());
            return;
        }

        a.add(point[n]);
        dfs(n + 1);
        a.remove(a.size() - 1);

        b.add(point[n]);
        dfs(n + 1);
        b.remove(b.size() - 1);
    }
}
