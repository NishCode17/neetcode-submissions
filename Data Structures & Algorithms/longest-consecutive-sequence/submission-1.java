class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longest=0;

        for(int s : set){
            if(!set.contains(s-1)){
                int curr=s;
                int length=1;
                
                while(set.contains(curr + 1)){
                    length++;
                    curr++;
                }

                longest=Math.max(longest,length);

            }

        }

        return longest;
    }
}
