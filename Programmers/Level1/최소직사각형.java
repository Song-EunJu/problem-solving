class Solution {
    public int solution(int[][] sizes) {
        int max=0, max2=0;

        for(int i=0;i<sizes.length;i++){
            int temp = Math.max(sizes[i][0], sizes[i][1]);
            int temp2 = Math.min(sizes[i][0], sizes[i][1]);
            if(temp > max)
                max=temp;
            if(temp2 > max2)
                max2 = temp2;
        }
        return max*max2;
    }
}