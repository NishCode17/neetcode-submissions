class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int stone : stones){
            queue.add(stone);
        }
        while(queue.size() > 1){
            int firstStone = queue.poll();
            int secondStone = queue.poll();
            int remStone = Math.abs(firstStone-secondStone);
            if(remStone!=0){
                queue.add(remStone);
            }
        }
        if(queue.isEmpty())
            return 0;
        return queue.peek();
    }
}
