class Solution {
    
    public List<String> simplifiedFractions(int n) {
        if(n == 1) {
            return new ArrayList<>();
        }
        
        var list = fractions(n);
        
        list.addAll(simplifiedFractions(n-1));
        return list;
    }
    
    private List<String> fractions(int n) {
        var list = new ArrayList<String>();
        for(int numerator = 1; numerator < n; numerator++) {
            if(gcd(numerator, n) == 1) {
                list.add(numerator + "/" + n);
            }
        }
        return list;
    }
    
    private int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
}