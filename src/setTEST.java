import java.util.ArrayList;
import java.util.List;

public class setTEST {
    public static void main(String[] args) {
//        Set<int[]> set = new HashSet<>();
//        set.add(new int[]{1,2});
//        set.add(new int[]{3,2});
//        set.add(new int[]{1,2});

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,2});

        int[] pos = new int[]{1,2};
        System.out.println(pos);
        if(list.contains(pos)) {
            System.out.println("true");
        }

        System.out.println(list);
//        System.out.println(set);
    }
}
