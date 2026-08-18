class Solution {
    public int maxArea(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int mxarea=0;

        while(i<j){
            int cheight=Math.min(nums[i],nums[j]);
            int area=cheight*(j-i);

            if(area>mxarea)mxarea=area;

            if(nums[i]>nums[j])j--;
            else i++;
        }

        return mxarea;
    }
}
