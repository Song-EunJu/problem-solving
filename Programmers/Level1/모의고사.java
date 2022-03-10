import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<Integer>();

        int[] score=new int[3]; // 맞춘 개수 담는 배열

        int rule[][] = {{1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}}; // 3명이 찍는 방식 저장

        /*
            answers = [1,3,2,4,2,1,3,2,4,2]
            1이 찍기 = [1,2,3,4,5]
        */
        for(int i=0;i<3;i++){
            int k=0;
            int n=rule[i].length;   // 5개면
            for(int j=0;j<answers.length;j++){
                if(rule[i][k]==answers[j]){
                    score[i]++;
                }
                k++;
                if((j+1)%n==0) // 찍는 방식이 5개면 다시 처음으로 돌아가야 함
                    k=0;
            }
        }

        int max=0;
        for(int i=0;i<3;i++){
            max=Math.max(max, score[i]); // 가장 높은 점수 찾기
        }

        for(int i=0;i<3;i++){
            if(score[i]==max)
                answer.add(i+1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}