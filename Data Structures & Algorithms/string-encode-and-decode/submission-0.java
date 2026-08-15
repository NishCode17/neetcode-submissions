class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        int j=1;
        ArrayList<String> ls = new ArrayList<>();

        while (j<str.length()){
            while (str.charAt(j)!='#'){
                j++;
            }
            String lenStr = str.substring(i, j);
            int len=Integer.parseInt(lenStr);

            int start=j+1;
            int end=start+len;

            String word = str.substring(start, end);

            ls.add(word);

            i=end;
            j=i+1;

        }

        return ls;
    }
}
