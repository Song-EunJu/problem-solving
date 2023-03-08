import java.util.ArrayList;
import java.util.List;

/**
1. (20, 35, 40, 45, 60, 100)
ex) (20, 100) (35, 40, 45) -> 120
2. (40, 40, 50, 50, 80, 100) → 팀의 몸무게 배열
ex) (40,40,50) (50, 80) → 130 으로 두 그룹의 몸무게 동일 / 한명 못나감

- 팀 내에서 2그룹으로 나눠서 경기에 나가야 함
- 나눈 2그룹이 몸무게 합이 같아야 함
- 경기에 못나가는 사람도 있을 수 있지만, 최대한 많은 사람이 나가야 함
* */

public class uplus1 {
    static boolean visit[];
    static List<Integer> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();
    static List<Integer> c = new ArrayList<>();
    static int p[];
    static int max = Integer.MIN_VALUE;
    static List<Integer> finalA;
    static List<Integer> finalB;

    public static void main(String[] args) {
        p = new int[]{20, 35, 40, 45, 60, 100}; // 140
//        p = new int[]{40, 40, 50, 50, 80, 100}; // 180

        dfs(0, 0, 0);
        System.out.println(max);
        System.out.println(finalA.size() + finalB.size()+" "+max);
//        System.out.println(finalB.toString());
    }

    public static void dfs(int idx, int aSum, int bSum){
        if(idx == p.length){
           if(aSum == bSum) {
               if(aSum > max){ // 합이 가장 작은 애들 구하기
                   max = aSum;
                   finalA = new ArrayList<>();
                   finalB = new ArrayList<>();
                   for (int aNum : a)
                       finalA.add(aNum);
                   for (int bNum : b)
                       finalB.add(bNum);
               }
           }
           return;
        }

        /**
         * A 그룹, B 그룹, 선택 안하는 경우 -> 3가지의 경우의 수로 나누어야 함
         * 1. A 그룹에 추가하는 경우
         *  -> A 리스트에 추가하고 aSum 인자에 지금까지의 A 합 + 현재 인덱스로 접근한 배열의 합 넣기
         *  -> 추가한 이후에는 방문처리 한 것을 해제해주듯이 list 에서 제거함
         *
         * 모든 인원을 다 뽑았을 때 A 그룹의 합, B 그룹의 합을 비교해야 함.
         * 이 때 반복문으로 매번 합을 구하지 않기 위해서 인자로 A 합, B 합을 인자로 가지고 다녔음
         * -> 가지고 다니게 하기 위해 sum + p[idx] 의 형태와 같이 넘김
         * */
        a.add(p[idx]);
        dfs(idx+1, aSum + p[idx], bSum);
        a.remove(a.size()-1);

        b.add(p[idx]);
        dfs(idx+1, aSum, bSum + p[idx]);
        b.remove(b.size()-1);

        c.add(p[idx]);
        dfs(idx+1, aSum, bSum);
        c.remove(c.size()-1);
    }
}
