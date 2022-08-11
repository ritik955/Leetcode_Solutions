class Solution{
    private int count = 0;
    private HashMap<Integer, Integer> position = new HashMap<>();
    public int minSwapsCouples(int[] row) {
        for (int i = 0; i < row.length; i++) {
            this.position.put(row[i], i);
        }
        for (int g = 0; g < row.length / 2; g++) {
            int c1 = row[2*g];
            int c2 = row[2*g+1];
            if((c1%2==0 && c2!=c1+1) || (c1%2!=0 &&c2!=c1-1)){
                int source_int = row[2 * g];
                int target_pos = source_int
                        % 2 == 0 ? position.get(source_int + 1) : position.get(source_int - 1);
                swap(row, 2 * g+1, target_pos);
                count++;
            }
        }
        return count;
    }
    private void swap(int[] row, int i, int j) {
        int tmp = row[i];
        row[i] = row[j];
        row[j] = tmp;
        this.position.put(row[i], i);
        this.position.put(row[j], j);
    }
}