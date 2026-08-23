class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] arr= new int[temp.length];
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<temp.length;i++){
	        if(stack.isEmpty() || temp[stack.peek()]>= temp[i]){
		        stack.push(i);
	        }
	        else{
		        while (!stack.isEmpty() && temp[i] > temp[stack.peek()]){
			        int prev = stack.pop();
                    arr[prev] = i - prev;
		        }
		        stack.push(i);
	        }
        }

        return arr;
    }
}
