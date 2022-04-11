class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];

        for(int i=0;i<ans.length;i++){
            for(int j=i+1;j<ans.length;j++){
                if(prices[i] > prices[j]){
                    ans[i]=j-i;
                    break;
                }
                ans[i]++;
            }
        }
        return ans;
    }
}