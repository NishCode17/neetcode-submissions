class Pair {
    int timestamp;
    String value;

    Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}


class TimeMap {
    HashMap <String, ArrayList<Pair>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        Pair obj=new Pair(timestamp,value);
        map.get(key).add(obj);
    }
    
    public String get(String key, int t) {
        if (!map.containsKey(key)) {
            return "";
        }

        ArrayList<Pair> ls=map.get(key);

        int left=0;
        int right=ls.size()-1;
        String ans="";

        while(left<=right){
            int mid=left+(right-left)/2;
            if(ls.get(mid).timestamp<=t){
                ans=ls.get(mid).value;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return ans;

    }
}
