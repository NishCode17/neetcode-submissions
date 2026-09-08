class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,new ArrayList<>(),ans);
        return ans;
    }

    public void backtrack(int index, int[] nums, int target, List<Integer> curr, List<List<Integer>> ans){

        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }

            if(nums[i]>target) break;

            curr.add(nums[i]);
            backtrack(i+1,nums,target-nums[i],curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}
