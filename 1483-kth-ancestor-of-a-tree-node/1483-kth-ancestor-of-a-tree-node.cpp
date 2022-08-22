class TreeAncestor {
public:
    int maxJump;
    vector<vector<int>> jump;
    
    TreeAncestor(int n, vector<int>& parent) {
        /*
        for a tree of n nodes,
        we can jump at most "maxJump" times
        */
        //notice the difference between log(it's natural log!) and log2(2-based)!!!
        maxJump = ceil(log2(n))+1;
        // maxJump = 20;
        //from 0 to maxJump
        jump = vector<vector<int>>(maxJump+1, vector<int>(n));
        
        //jump 2^0 steps upward
        jump[0] = parent;
        
        for(int j = 1; j <= maxJump; j++){
            for(int node = 0; node < n; node++){
                //from node, jump 2^(j-1) steps upward
                int halfway = jump[j-1][node];
                jump[j][node] = (halfway == -1) ? -1 : jump[j-1][halfway];
            }
        }
    }
    
    int getKthAncestor(int node, int k) {
        // cout << "k: " << k << ", j: ";
        for(int j = 0; j <= maxJump; j++){
            if(k & (1 << j)){
                /*
                view "k" as a bitset,
                and we are decompose "k" into the powers of 2
                when "k"'s "j"th bit is set,
                that means one of the component of k is 2^j,
                so we jump up 2^j steps upward
                */
                // cout << j << " ";
                node = jump[j][node];
                if(node == -1) break;
            }
        }
        // cout << endl;
        return node;
    }
};