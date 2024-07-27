class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i< pre.length; i++){
            adj.get(pre[i][1]).add(pre[i][0]);
            indegree[pre[i][0]]++;
        }

        //check if graph has cycles using topological sort algorithm
        Queue<Integer> queue = new LinkedList<>();
        //push all the nodes with indegree 0 in the queue
        for(int i =0; i< numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int nodesVisited = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            nodesVisited++;

            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        return nodesVisited == numCourses;
    }
}