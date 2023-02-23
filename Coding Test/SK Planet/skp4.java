/**
 * n : 1~100 차선 수
 * m : 1~100 차선 너비 합
 * k : 1~100 차선 최대 너비
 * */
class skp4 {
    static int total = 0;
    static int zz = 0;
    public int solution(int n, int m, int k) {
        divideRoad(0, 0, n, m, k);
        System.out.println(total%1000007);
        return total;
    }

    public static void divideRoad(int cnt, int sum, int n, int m, int k) {
        zz++;
        if(sum >= m && cnt!=n)
            return;

        if (cnt == n) {
            if(sum == m)
                total++;
            return;
        }

        for(int i=k;i>=1;i--){
            if(sum+i > m)
                continue;
            divideRoad(cnt + 1, sum+i, n, m, k);
        }
    }
}
