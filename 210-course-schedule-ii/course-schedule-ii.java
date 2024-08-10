class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
       int[] indegree = new int[numCourses];
       List<List<Integer>> adj = new ArrayList<>();

       for(int i =0; i<numCourses; i++){
        adj.add(new ArrayList<>());
       }

       for(int i = 0; i < pre.length; i++){
        adj.get(pre[i][1]).add(pre[i][0]);
        indegree[pre[i][0]]++;
       }

       Queue<Integer> queue = new LinkedList<>();

       for(int i = 0; i < numCourses; i++){
        if(indegree[i]== 0){
            queue.offer(i);
        }
       }

       int nodesVisited = 0;
       List<Integer> ans = new ArrayList<>();

       while(!queue.isEmpty()){
            int node = queue.poll();
            nodesVisited++;
            ans.add(node);

            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;

                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }

            }
       }

       if(nodesVisited == numCourses){
             return ans.stream().mapToInt(Integer::intValue).toArray();
        }

        return new int[0];
    }
}