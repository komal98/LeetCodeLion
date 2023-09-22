class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<=numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[numCourses];

        for(int[] prerequisite : prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            ans[i++] = node;

            for(int edge : adj.get(node)){
                indegree[edge]--;
                if(indegree[edge] == 0)
                {
                    q.add(edge);
                }
            }

        }

        if(i==numCourses) return ans;
        int arr[] = {};
        return arr;
    }
}