class Solution {
public:
    
    int global_ret = 0;
    
    static bool cmp(vector<int>& a, vector<int>& b){
        return a[2] < b[2];
    }
    
    int p[105];
    
    int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    
    int kruskal(bool must_pick, int idx, int cur_idx, int n, vector<vector<int>>& edges){
        
        for(int i = 0; i < n; i++) p[i] = i;
        
        int cnt = 0, ret = 0;
        
        if(idx != -1 and must_pick){
            auto t = edges[cur_idx];
            int a = t[0], b = t[1], c = t[2];
            ret += c;
            cnt += 1;
            int pa = find(a), pb = find(b);
            p[pa] = pb;
        }
        
        for(int i = 0; i < edges.size(); i++){
            if(!must_pick and idx == edges[i][3]) continue;
            int a = edges[i][0], b = edges[i][1], c = edges[i][2];
            int pa = find(a), pb = find(b);
            if(pa == pb) continue;
            else{
                p[pa] = pb;
                ret += c;
                cnt += 1;
            }
        }
        
        if(cnt != n - 1) ret = -1;
        
        if(idx == -1){
            global_ret = ret;
        }
        
        return ret;
    }
    
    vector<vector<int>> findCriticalAndPseudoCriticalEdges(int n, vector<vector<int>>& edges) {
        vector<vector<int>> ret;
        vector<int> critical;
        vector<int> pseudo;
        
        for(int i = 0; i < edges.size(); i++){
            edges[i].push_back(i);
        }
        
        sort(edges.begin(), edges.end(), cmp);
        
        for(int i = 0; i < edges.size(); i++){
            edges[i].push_back(i);
        }
        
        kruskal(false, -1, -1, n, edges);
        
        if(global_ret == -1) return ret;
        
        for(int i = 0; i < edges.size(); i++){
            int idx = edges[i][3], cur_idx = edges[i][4];
            // if do not pick, 
            int c = kruskal(false, idx, cur_idx, n, edges);
            if(c == -1 or c > global_ret){
                critical.push_back(idx);
                continue;
            }
            c = kruskal(true, idx, cur_idx, n, edges);
            if(c == global_ret) pseudo.push_back(idx);
            
        }
        
        ret.push_back(critical);
        ret.push_back(pseudo);
        return ret;
    }
};