class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n=cars.length;
        double res[]=new double[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=n-1; i>=0; i--){
            int positionc=cars[i][0];
            int speedc=cars[i][1];
            res[i]=-1;
            while(!stack.isEmpty()){
                int index=stack.peek();
                int position=cars[index][0];
                int speed=cars[index][1];
                if(speedc<=speed || res[index]>=0 && ((double)position-positionc)/(speedc-speed)>=res[index]) stack.pop();
                else break;
            }
            if(!stack.isEmpty()){
                 int index=stack.peek();
                int position=cars[index][0];
                int speed=cars[index][1];
                res[i]=((double)position-positionc)/(speedc-speed);
            }
            stack.push(i);
        }
        return res;
    }
}