class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numOfComponents = 0;
        boolean[] visit = new boolean[n];

        for(int i = 0; i<n; i++){
            if(!visit[i]){
                numOfComponents++;
                dfs(isConnected,visit, i);
            }
        }
        
        return numOfComponents;
    }
    
    void dfs(int[][] isConnected, boolean [] visit, int node){
        visit[node] = true;
        for(int i = 0; i<isConnected.length; i++){
            if(isConnected[node][i] == 1 && !visit[i])
            dfs(isConnected,visit,i);
        }
    }
}