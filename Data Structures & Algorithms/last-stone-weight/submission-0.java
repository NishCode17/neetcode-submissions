class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue= new PriorityQueue<>(Collections.reverseOrder());
        for(int num : stones){
            queue.offer(num);
        }
        return smash(queue);
    }

    public int smash(PriorityQueue<Integer> queue){

        if(queue.isEmpty()){
            return 0;
        }

        if(queue.size()==1){
            return queue.peek();
        }

        int a=queue.poll();
        int b=queue.poll();

        if(a!=b){
            queue.offer(Math.abs(a-b));
        }

        return smash(queue);
    }
}
