class Solution {

    public int calc(int[] num, int input){
        int ans=0;
        for(int i : num){
            ans+=(i+input-1)/input;
        }

        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i : piles){
            max=Math.max(max,i);
        }

        int l=1;
        int r=max;

        int ans=0;

        while(l<=max){
            int mid=l+(max-l)/2;

            if(calc(piles,mid)<=h){
                ans=mid;
                max=mid-1;
            }else{
                l=mid+1;
            }
            
        }

        return ans;
    }
}
