// 단순 반복문으로 계산하는 경우 test case 9,10 시간초과
// class Solution {
//     public long[] solution(long[] numbers) {
//         long[] answer = new long[numbers.length];
//         for(int i=0;i<numbers.length;i++){
//             String binaryNumber = Long.toBinaryString(numbers[i]);

//             while(true){
//                 int diff, temp;
//                 String binary = Long.toBinaryString(++numbers[i]);

//                 // 길이가 다른 경우 == 앞자리가 다른 경우
//                 temp = (binaryNumber.length() != binary.length()) ? 1 : 0;
//                 diff = (binaryNumber.length() != binary.length()) ? 1 : 0;

//                 for(int j=0;j<binaryNumber.length();j++){
//                     if(binaryNumber.charAt(j) != binary.charAt(temp++))
//                         diff++;
//                     if(diff>2)
//                         break;
//                 }
//                 if(diff<=2){
//                     answer[i]=numbers[i];
//                     break;
//                 }
//             }
//         }
//         return answer;
//     }
// }

// 짝수와 홀수로 나누어 계산
/*
    3 -> 5    = 3 + 2 (2^1)
    7 -> 11   = 7 + 4 (2^2)
    15 -> 23  = 15 + 8 (2^3)
    31 -> 47  = 31 + 16 (2^4)

    - numbers[i] + 2^(n-1)
*/
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0;i<numbers.length;i++){
            if(((numbers[i]+1) & numbers[i]) == 0){ // 2의 제곱수-1 인지 확인
                answer[i] = (numbers[i]==0) ? 1 : numbers[i] + (long)Math.pow(2,(Math.log10(numbers[i]+1)/Math.log10(2)-1)); // numbers[i]+2^(n-1)
            }
            else{
                if(numbers[i]%2==0) // 짝수인 경우
                    answer[i]=numbers[i]+1;
                else { // 2의 제곱수-1 이 아닌 홀수인 경우
                    String binary = Long.toBinaryString(numbers[i]);
                    for(int j=binary.length()-1;j>0;j--){
                        if(binary.charAt(j)=='1' && binary.charAt(j-1)=='0'){
                            String binaryStr = binary.substring(0,j-1)+"10"+binary.substring(j+1,binary.length());
                            answer[i]=Long.parseLong(binaryStr, 2);
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}