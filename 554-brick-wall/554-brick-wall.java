class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        int n = wall.size();
        int max = 0;
        for (List<Integer> row:wall) {
            Iterator<Integer> it = row.iterator();
            int sum = 0;
            while (it.hasNext()) {
                sum += it.next();
                if (it.hasNext()) {
                    if (!count.containsKey(sum)) {
                        count.put(sum, 0);
                    }
                    count.put(sum, count.get(sum) + 1);
                    max = Math.max(max, count.get(sum));
                }
            }
        }
        return n - max;
    }
}