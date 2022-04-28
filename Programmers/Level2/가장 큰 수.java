import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String str[] = new String[numbers.length];
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<numbers.length;i++){
            str[i]=String.valueOf(numbers[i]);
        }

        /*
            100, 34를 비교한 경우 -> 첫글자 1-3 = -2 리턴
            95, 94 를 비교한 경우 -> 두번째 글자 5-4=1
        */

        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });

        for(int i=0;i<str.length;i++){
            sb.append(str[i]);
        }

        return sb.toString().charAt(0)=='0'?"0":sb.toString();
    }