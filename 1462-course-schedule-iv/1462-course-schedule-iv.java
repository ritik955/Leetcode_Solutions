class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] p, int[][] q) {
        List<Integer>[] g = new List[n];
        //pre: prerequisite course k -> courses that have course k as prerequisites
        Map<Integer, Set<Integer>> pre = new HashMap<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            pre.put(i, new HashSet<>());
        }
        for(int[] pp : p) {
            g[pp[0]].add(pp[1]);
        }        
        for(int i = 0; i < n; i++) {
            topo(g, visited, pre, i);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] qq : q) {
            ans.add(pre.get(qq[0]).contains(qq[1]));
        }
        return ans;
    }
    private void topo(List<Integer>[] g, boolean[] visited, Map<Integer, Set<Integer>> pre, int u) {
        if(!visited[u]) {       
            Set<Integer> prevSet = pre.get(u);
            for(int v : g[u]) {
                if(!visited[v]) {
                    topo(g, visited, pre, v);
                }  
                Set<Integer> set = pre.get(v);
                prevSet.add(v);
                prevSet.addAll(set);              
            }
            visited[u] = true;            
        }
    }
}