class Solution {
    int n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] visited = new boolean[n];
        int groups = 0;
        for(int i =0; i<n; i++){
            if(!visited[i]){
                dfs(isConnected,visited,i);
                groups++;
            }
        }
        return groups;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i){
        for(int j = 0; j<n; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected,visited,j);
            }
        }
    }
}