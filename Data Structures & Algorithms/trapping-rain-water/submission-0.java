class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int water=0;
        int leftMx=0;
        int rightMx=0;

        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftMx){
                    leftMx=height[left];
                }else{
                    water+=leftMx-height[left];
                }
                left++;
            }
            else{
                if(height[right]>=rightMx){
                    rightMx=height[right];
                }
                else{
                    water+=rightMx-height[right];
                }
                right--;
            }
        }

        return water;

    }
}
