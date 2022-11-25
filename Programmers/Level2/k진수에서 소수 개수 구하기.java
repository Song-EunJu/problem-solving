// 이 코드로 한 경우 / 1, 11 런타임 + 2 실패

// import java.util.*;
// class Solution {
//     public int solution(long n, long k) {
//         int answer = 0;
//         StringBuilder sb = new StringBuilder();
//         long tempN = n;
//         String prime = "";

//         if(k!=10){ // 10진수가 아닌 경우에만 k진수로 바꾸기
//             while(tempN/k != 0){
//                 long remainder = tempN%k; // 나머지
//                 tempN = tempN/k;
//                 sb.append(remainder);
//             }
//             sb.append(tempN);
//             for(int i=sb.length()-1;i>=0;i--){
//                 prime+=sb.charAt(i);
//             }
//         }
//         else // 10진수인 경우 그대로 사용
//             prime = String.valueOf(n);

//         // 12011013013
//         int prevZero = 0;
//         int nextZero = 0;
//         for(int i=0;i<prime.length();i++){
//             long num = 0;

//             if(prime.charAt(i) == '0'){
//                 if(prevZero == 0){ // 0이 처음 나온 경우
//                     prevZero = i;
//                     String str = prime.substring(0, prevZero); // 2. P0 구하기
//                     num = !(str.equals("")) ? Integer.parseInt(str) : 0;
//                 }
//                 else {
//                     if(nextZero != 0) // 0이 이미 여러번 나온 경우에는
//                         prevZero = nextZero;

//                     nextZero = i; // 지금 나온 거를 next로
//                     String str = prime.substring(prevZero, nextZero); // 1. 0P0 구하기
//                     num = !(str.equals("")) ? Integer.parseInt(str) : 0;
//                 }
//                 if(num != 0){
//                     if(isPrime(num)){
//                         answer++;
//                     }
//                 }
//             }
//         }

//         if(!(prime.substring(nextZero, prime.length()).equals(""))){ // 3. 0P 구하기
//             long num = Integer.parseInt(prime.substring(nextZero, prime.length()));

//             if(isPrime(num))
//                 answer++;
//         }

//         if(prevZero == 0 && nextZero == 0) { // 4. P 구하기
//             if(isPrime(Integer.parseInt(prime))){
//                 answer++;
//             }
//         }

//         return answer;
//     }

//     // 소수 판별
//     public static boolean isPrime(long number){
//         if(number <= 1)
//             return false;

//         for(long i=2;i*i<=number;i++){
//             if(number % i == 0)
//                 return false;
//         }
//         return true;
//     }
// }

/*
케이스를 너무 쪼개서 생각하는 바람에 해결하지 못한 문제,,
결국 4가지의 경우는 0을 기준으로 쪼갠 배열의 정수값이 소수인지 판별만 하면 되는 거였음,,

[ 새로 알게 된 것 ]
- sb.reverse(); // 문자열 뒤집기!

[ 다시 기억할 것 ]
- n진수 구할 때 나머지와 나누기 연산을 잘 이용하기
- equals 로 문자열 비교
*/
import java.util.*;
class Solution {
    public int solution(long n, long k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        long tempN = n;

        while(tempN > 0){
            sb.append(tempN%k); // 나머지
            tempN /= k;
        }
        sb.reverse();

        String[] primes = sb.toString().split("0");

        // 12011013013
        for(String prime: primes){
            if(prime.equals(""))
                continue;
            if(isPrime(Long.parseLong(prime)))
                answer++;
        }

        return answer;
    }

    // 소수 판별
    public static boolean isPrime(long number){
        if(number <= 1)
            return false;

        for(long i=2;i*i<=number;i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }
}