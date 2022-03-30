class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String skillArr[] = skill.split("");
        for(int j=0;j<skill_trees.length;j++){ // 주어진 skill_trees ["BACDE", "CBADF", "AECB", "BDA"] 배열을 돌면서
            int max = Integer.MIN_VALUE;
            int cnt=0;
            for(int i=0;i<skillArr.length;i++){ // 주어진 skill 문자열의 각 문자 배열 C,B,D ... 을 돌면서
                if(skill_trees[j].contains(skillArr[i])) { // 문자열에 해당 글자가 포함된 경우
                    if(cnt!=0){ // 순서 중에 하나가 빠진 경우 eX) CBD - CED
                        max = -1;
                        break;
                    }
                    int num = skill_trees[j].indexOf(skillArr[i]); // 몇번째 위치에 있는지 계산
                    if(max < num) {// 포함되어 있는 경우에 값이 점점 커지는 겨웅에만 max값에 담기
                        max = num;
                    }
                    else // 그게 아니라면 -1 로 초기화
                        max = -1;
                }
                else // 문자열 중에 문자가 포함되지 않은 경우
                    cnt++;
                if(max == -1)
                    break;
            }
            if(max != -1)
                answer++;
        }
        return answer;
    }
}
