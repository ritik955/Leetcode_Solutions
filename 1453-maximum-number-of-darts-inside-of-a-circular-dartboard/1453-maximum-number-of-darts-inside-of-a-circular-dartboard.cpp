class Solution {



public:



    #define PI acos(-1)



    vector<pair<double,int>>vp;



    int R;



    int check(vector<vector<int>>& v,int pos)



    {



        for(int i=0;i<v.size();i++)



        {



            if(i!=pos)



            {



                double dis=sqrt((v[i][0]-v[pos][0])*(v[i][0]-v[pos][0])+(v[i][1]-v[pos][1])*(v[i][1]-v[pos][1]));



                if(dis>2*R)



                    continue;



               double A=atan2((v[i][1]-v[pos][1]),(v[i][0]-v[pos][0]));  



               double B=acos(dis/(2.0*R));



               vp.push_back(make_pair(A-B,-1));



               vp.push_back(make_pair(A+B,1));



            }



        }



        sort(vp.begin(),vp.end());



        int cnt=1,ans=1;



        for(int i=0;i<vp.size();i++)



        {



            if(vp[i].second==-1)



            {



                cnt++;



            }



            else



            {



                cnt--;



            }



            ans=max(ans,cnt);



        }



        vp.clear();



        return ans;



    }



    int numPoints(vector<vector<int>>& points, int r) {



        R=r;



        int ans=0;



        for(int i=0;i<points.size();i++)



        {



            ans=max(ans,check(points,i));



        }



        return ans;



    }



};
