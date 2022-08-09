class Solution {
    private int[] a;
    private Random rand;
    public Solution(int[] nums) {
        a=nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        List<Integer> indices = new ArrayList<>();
        for(int i=0; i<a.length; i++) {
            if(a[i] == target) {
                indices.add(i);
            }
        }
        int n = indices.size();
        int res = indices.get(rand.nextInt(n));
        return res;
    }
}