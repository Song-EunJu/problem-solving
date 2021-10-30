import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length; // 아무것도 하기 전에  체육복 가지고 있는 애들 수 (n명 - 체육복잃어버린 애)

        // 배열을 리스트로 바꾸기
        ArrayList<Integer> lostList = new ArrayList<Integer>();
        ArrayList<Integer> resList = new ArrayList<Integer>();

        // asList() 를 사용할 수 없어서 for문으로 넣어줌
        for(int lostMember : lost){
            lostList.add(lostMember);
        }

        for(int resMember : reserve){
            resList.add(resMember);
        }

        // 여벌 옷을 가져온 애가 도난당한 경우부터 빼주고 시작 (남한테 빌려줄 수 없기 때문에)

        for(int i=0;i<resList.size();i++){
            int num = resList.get(i);
            if(lostList.contains(num)){
                lostList.remove(Integer.valueOf(num));
                resList.remove(Integer.valueOf(num));
                answer++; // 도난 당한 애를 위에서 빼줬지? 근데 걔가 여벌옷이 있는 애야 그럼 걔는 체육복이 있으니까 다시 ++
                i--; // remove 를 해주면 resList.size() 의 크기가 달라지기 때문에 i-- 가 없으면 indexArray 무슨 에러남
            }
        }

        for(int i=0;i<resList.size();i++){// 여벌 체육복 있는 친구들 번호 하나씩 꺼내오기
            int num = resList.get(i);

            if(lostList.contains(num-1) || lostList.contains(num+1)){ // 앞뒤 번호 친구가 lost 리스트에 있으면

                if(lostList.contains(num-1))
                    lostList.remove(Integer.valueOf(num-1));
                else if(lostList.contains(num+1))
                    lostList.remove(Integer.valueOf(num+1));

                resList.remove(Integer.valueOf(num));
                answer++;
                i--;
            }
        }
        return answer;
    }
}