class Solution {

    List<List<Integer>> ans=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0,nums,new ArrayList<>());
        return ans;    
    }

    public void backtrack(int index,int [] nums, List<Integer>current){
        ans.add(new ArrayList<>(current));

        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);

            backtrack(i+1,nums,current);

            current.remove(current.size()-1);
        }
    }
}
