import java.lang.Math;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        // 첫 위치 설정
        int lastLeft = 10;
        int lastRight = 12;

        for(int number : numbers){
            if(number==0)
                number=11;

            if(number%3==0){ // 3,6,9 인 경우 (오른손)
                sb.append("R");
                lastRight = number;
            }
            else if(number%3==1){ // 1,4,7 인 경우 (왼손)
                sb.append("L");
                lastLeft = number;
            }
            else{ // 중앙 숫자인 경우 (오른손, 왼손 거리 재야함)

                int leftDist = Math.abs((lastLeft-1)/3-(number-1)/3) + Math.abs((lastLeft-1)%3-1);
                int rightDist = Math.abs((lastRight-1)/3-(number-1)/3) + Math.abs((lastRight-1)%3-1);

                if(leftDist == rightDist){ // 거리가 같은 같은 경우
                    if(hand.equals("right")){
                        sb.append("R");
                        lastRight = number;
                    }
                    else{
                        sb.append("L");
                        lastLeft = number;
                    }
                }
                else{
                    if(leftDist>rightDist){ // 오른손이 더 가까운 경우
                        sb.append("R");
                        lastRight = number;
                    }
                    else{
                        sb.append("L");
                        lastLeft = number;
                    }
                }
            }
        }
        return sb.toString();
    }
}