class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //think of this representation as a graph
        //create adj list for the graph

        List<List<Integer>> adj = new ArrayList<>();

        //initialize adj list
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        //populate adj list
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return minTimeToCollectApples(0,adj,hasApple,0);
        
    }

    int minTimeToCollectApples(int index, List<List<Integer>> adj, List<Boolean> hasApple, int parent){
        //total time
        int total = 0;

        //for each neighbour in the current node
        for(int nbr : adj.get(index)){
            //if neighbor is parent node skip
            if(nbr == parent) continue;
            
            //recursively call the helper function for each neighbour
            total += minTimeToCollectApples(nbr,adj,hasApple,index);
        }

        if(index!=0 && (hasApple.get(index) || total>0)){
            total +=2;
        }
        return total;
    }
}