///**
//1. (20, 35, 40, 45, 60, 100)
//ex) (20, 100) (35, 40, 45) -> 120
//2. (40, 40, 50, 50, 80, 100) → 팀의 몸무게 배열
//ex) (40,40,50) (50, 80) → 130 으로 두 그룹의 몸무게 동일 / 한명 못나감
//
//- 팀 내에서 2그룹으로 나눠서 경기에 나가야 함
//- 나눈 2그룹이 몸무게 합이 같아야 함
//- 경기에 못나가는 사람도 있을 수 있지만, 최대한 많은 사람이 나가야 함
//- 반환 값은 뭐하라 했는지 기억안나니까 나눈 두 그룹 배열을 구해보겠음
//* */
//
///* 집합 분할 -> NP 문제
//정수 중복집합 S가 있을 때, S를 S1과 S2로 나누어서 두 부분집합에 속한 숫자들의 합이 똑같도록 할 수 있는지를 묻는 문제
//
//*/
//
//public class uplus1 {
//    static boolean visit[];
//    public static void main(String[] args) {
//        // 최대한 많은 사람들이 나가도록, 몸무게 합이 같도록.
//        int[] p = {20, 35, 40, 45, 60, 100};
//        int[] ar = solution(p);
//
//        for(int i=0; i<ar.length; i++){
//            System.out.println(ar[i]+ " ");
//        }
//    }
//
//    public static int[] solution(int[] p) {
//        visit = new boolean[p.length];
//        int sum = 0;
//        calc(p, sum);
//
//    }
//
//    public static void calc(int[] p, int sum){
//        int notVisited = 0;
//        for(int i=0;i<visit.length;i++){
//            if(visit[i] == false)
//                notVisited += p[i];
//        }
//
//        if(){
//            // check 함수
//            // visit = true 인 애랑, false 인 애랑
//
//        }
//
//        // 부분집합 같긴 한데, 선택을 안하는 경우의 수도 존재하기 때문에..
//
//        for(int i=0;i<p.length;i++){
//            if(visit[i])
//                continue;
//
//            visit[i] = true;
//            calc(p, sum + p[i]);
//            visit[i] = false;
//            calc(p, sum);
//        }
//    }
//
//    public static boolean check(){
//        // visit 처리한 애랑 아닌 애랑 합이 같으면
//    }
//}
