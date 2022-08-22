class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
 
          int low=1, high=1000000001;   //setting limit
          while(low<high)  // usual binary search
          {
              int mid=(low+high)/2,total=0;
              for(int i=0;i<bloomDay.size();i++)  // searching how many bouquets we can make
              {
                  int day=0;
                  if(bloomDay[i]<=mid) // consecutive flowers after mid days
                  {
                      while(i<bloomDay.size()&&bloomDay[i]<=mid)
                      {
                          day++;
                          i++;
                      }
                      i--;
                      total+=day/k;  // making bouquets from consecutive flowers
                  }
              }
              if(total>=m)  // if bouquets are more than target then its not optimal
              {
                  high=mid;
              }
              else     // if bouquets are less than target then its wrong
              {
                  low=mid+1;
              }
          }
          if(low==1000000001)  // in the case of not possible
              return -1;
          return low;
    }
};