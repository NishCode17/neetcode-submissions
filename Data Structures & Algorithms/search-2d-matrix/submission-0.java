class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ans=-1;
        int l=0;
        int r=matrix.length-1;

        while(l<=r){
            int m=l+(r-l)/2;
            if(matrix[m][0]<=target){
                ans=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }

        if(ans==-1){
            return false;
        }

        int k=0;
        int j=matrix[ans].length-1;

        while(k<=j){
            int mid=k+(j-k)/2;
            if(matrix[ans][mid]==target){
                return true;
            }
            else if(matrix[ans][mid]>target){
                j=mid-1;
            }
            else{
                k=mid+1;
            }
        }

        return false;
    }
}
