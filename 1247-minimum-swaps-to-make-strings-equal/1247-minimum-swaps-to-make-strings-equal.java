class Solution {
    public int minimumSwap(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return -1;
        }
        
        int diffX = 0, diffY = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    diffX += 1;
                } else {
                    diffY += 1;
                }
            }
        }
        return (diffX + diffY) % 2 == 0 ? (diffX + 1) / 2 + (diffY + 1) / 2 : -1;
    }
}