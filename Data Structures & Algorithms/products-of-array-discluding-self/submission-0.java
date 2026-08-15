class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] arr= new int[nums.length];
        int i=0;
        int left=1;
        int right=1;

        for(int c : nums){
            arr[i++]=left;
            left*=c;
        }

        for(int j=nums.length-1;j>=0;j--){
            arr[j] *= right;
            right *= nums[j];
        }

        return arr;

    }
}  
