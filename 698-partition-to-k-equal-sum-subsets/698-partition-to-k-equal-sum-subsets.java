class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        return process(0, nums, visited, sum/k, sum/k, k);
    }
    private boolean process(int start, int[] nums, boolean[] visited, int sum, int left, int togo) {
        if (togo == 1) {
            return true;
        }
        if (left == 0) {
            return process(0, nums, visited, sum, sum, togo - 1);
        }
        for (int i = start; i < nums.length; i ++) {
            if (nums[i] > left) {
                return false;
            }
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            if (process(i + 1, nums, visited, sum, left - nums[i], togo)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

}