class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for (int count : map.values()) {
            pq.offer(count);
        }

        Queue<int[]> queue=new LinkedList<>();
        int time=0;

        while(!pq.isEmpty() || !queue.isEmpty()){
            if(!pq.isEmpty()){
                int freq=pq.poll();
                freq--;
                if(freq>0){
                    queue.offer(new int[]{freq,time+n+1});
                }
            }

            time++;

            if(!queue.isEmpty() && queue.peek()[1] == time){
                int f=queue.poll()[0];
                pq.offer(f);
            }
            
        }

        return time;
    }
}
