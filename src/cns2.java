import java.util.*;

public class cns2 {
    public static void main(String[] args) {
        int n = 5;
        int solution[][] = {{1,1,0,0,1},{1,0,0,1,0},{0,0,1,1,0},{0,1,0,0,0},{1,0,1,0,0},{0,0,1,0,1}};
        // [1,3]

//        int n = 4;
//        int solution[][] = {{0,0,0,1},{0,1,0,1},{1,0,0,1},{0,0,1,0},{0,0,1,0}};

        solution(n, solution);
    }

    public static int[] solution(int n, int[][] problems) {
        // -> 당연히 4를 선택해야 함 2,4 // -> hashSet에 넣었을 때 가장 size 변화가 큰 값으로..

        List<int[]> list = new ArrayList<>(); // 문제 번호 담는 리스트 (아직 안빠진애들)

        for(int i=0;i<problems.length;i++){
            int cnt = 0;
            for(int j=0;j<problems[i].length;j++){
                if(problems[i][j] == 1)
                    cnt++;
            }
            list.add(new int[]{i+1, cnt});
        }
        // 문제 당 문제유형이 몇개씩 붙어있는지 아는 배열

        Collections.sort(list, (o1, o2) -> o2[1] - o1[1]);

        Set<Integer> typeSet = new HashSet<>(); // 풀어야할 유형 set
        List<Integer> finalNum = new ArrayList<>(); // 풀어야 할 문제 list

        // 1트는 그냥넣고 시작
        int firstNum = list.get(0)[0]; // 1번문제
        list.remove(0); // 문제리스트에서 1번 문제 지움
        finalNum.add(firstNum);

        for(int j=0;j<n;j++){ // problem[0] = [1,1,0,0,1];
            if(problems[firstNum-1][j]==1)
                typeSet.add(j+1); // // 문제 번호에 해당하는 유형을 set 에 넣음
        }

        while(typeSet.size() != n){ // 유형이 모두 생길 경우 끝남
            for(int[] li : list){ // (3,2) (1,1) (4,1) (5,1)
                int num = li[0]; // 문제 번호
                int sizeBefore = typeSet.size(); // 문제를 선택하기 전 set의 사이즈
                List<Integer> forSet = new ArrayList<>(); // 선택안하면 다시 되돌리기 위한 리스트

                for(int j=0;j<n;j++){ // problem[0] = [1,0,0,1];
                    if(problems[num-1][j]==1){
                        typeSet.add(j+1);
                        int sizeAfter = typeSet.size();
                        if(sizeBefore != sizeAfter) { // 셋에 없는 걸 넣은 경우
                            forSet.add(j+1);
                        }
                    }
                }

                if(typeSet.size() == n){
                    finalNum.add(num);
                    break;
                }
                else{ // 다 채울 수 잇는 경우의수가 없는 경우 다시 되돌림
                    for(Integer removeItg: forSet)
                        typeSet.remove(removeItg);
                }

                // 만약에 다 채울 수 있느 경우의 수가 잇다 ? 걔로 감. 그게 아니면 ?? 그냥 맨 처음애 선택

            }
            // 맨처음거 선택
            int first = list.get(0)[0]; // 문제 번호
            for(int j=0;j<n;j++){ // problem[0] = [1,0,0,1];
                if(problems[first-1][j]==1){
                    typeSet.add(j+1);
                }
            }
        }

        // /*
        //     그리디 :  가장 문제유형이많은 것 부터 선택하기
        //     -> 그러려면 정렬이 필요함. 문제 유형이 많은 거 부터 1이 가장 많은 애
        // */

        int[] answer = new int[finalNum.size()];
        for(int j=0;j<finalNum.size();j++){
            answer[j] = finalNum.get(j);
        }
        return answer;
    }
}

