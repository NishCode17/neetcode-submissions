class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->Integer.compare(b[0]*b[0]+b[1]*b[1],a[0]*a[0]+a[1]*a[1]));

        for(int[] point : points){
            queue.offer(point);

            if(queue.size()>k){
                queue.poll();
            }
        }

        int[][] ans=new int[k][2];
        int i=0;

        while(!queue.isEmpty()){
            ans[i++]=queue.poll();
        }

        return ans;
    }
}
