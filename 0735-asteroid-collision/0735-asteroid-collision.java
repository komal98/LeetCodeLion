class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
           while(!stack.isEmpty()&&asteroids[i]<0&&stack.peek()>0){
               int d=asteroids[i]+stack.peek();
               if(d<0)
               stack.pop();
               else if(d>0)
               asteroids[i]=0;
               else{
                asteroids[i]=0;
                stack.pop();
               }
              
           }
           if(asteroids[i]!=0)
           stack.push(asteroids[i]);

        }
        int n=stack.size();
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--){
            ans[i]=stack.pop();
        }
    return ans;
    }
}