class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int month[]={31,29,31,30,31,30,31,31,30,31,30,31};
        int day = 0;

        for(int i=0;i<a-1;i++){
            day+=month[i];
        }
        day+=(b-1); // 날짜 더하기

        if(day%7==0)
            answer="FRI";
        else if(day%7==1)
            answer="SAT";
        else if(day%7==2)
            answer="SUN";
        else if(day%7==3)
            answer="MON";
        else if(day%7==4)
            answer="TUE";
        else if(day%7==5)
            answer="WED";
        else if(day%7==6)
            answer="THU";


        /*
        1/1 = 금요일
        2/29 = 월요일

        2-1 = 1월 31
        29-1 = 28일

        59/7 = 8 ... 3 (금요일+3=월요일)

        1,3,5,7,8,10,12 - 31일 개월수
        4,6,9,11 - 30일
        2 - 29일

        */
        return answer;
    }
}
