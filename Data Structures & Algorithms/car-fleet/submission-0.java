class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] arr= new int[position.length][2];
        for(int i=0;i<position.length;i++){
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
        }

        Arrays.sort(arr,(a,b)->Integer.compare(b[0],a[0]));
        int fleetCount=0;
        double fleetTime=0;
        for(int j=0;j<arr.length;j++){
            int pos=arr[j][0];
            int spd=arr[j][1];
            double time=(double)(target-pos)/spd;

            if(time>fleetTime){
                fleetCount++;
                fleetTime=time;
            }
            else{
                continue;
            }
        }

        return fleetCount;

    }
}
