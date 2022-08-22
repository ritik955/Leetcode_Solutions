class Solution {
   //O(N)time O(N)space
public int longestSubarray(int[] nums) {
    int len = nums.length;
    int[] dp = new int[len];
    dp[0] = nums[0];
    int count = 0;
    int res = 0;
    for(int i = 1; i < len; i++){
        if(nums[i] == 1){
            dp[i] = dp[i - 1] + 1;
        }else{
            if(nums[i-1] == 0){
                count = 0;
            }else{
                dp[i] = dp[i - 1] - count;
                count = dp[i];
            }
        }
        res = Math.max(res, dp[i]);
    }
    return res == len ? res - 1 : res;
}
}