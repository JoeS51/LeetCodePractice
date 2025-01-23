class Solution {
    public int countServers(int[][] grid) {
       Set<Integer> row = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>(); 
        int count = 0;
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               if (grid[i][j] == 1) {
                total++;
                System.out.println(dfs(i, j, grid, 1, 0));
                 if (!(dfs(i+1, j, grid, 1, 0) || dfs(i-1, j, grid, -1, 0) || dfs(i, j-1, grid, 0, -1) || dfs(i, j+1, grid, 0, 1))) {
                    count++;
                    
                    System.out.println("HERE");
                 } 
               } 
            }
        }
        return total - count;
    }
    private boolean dfs (int i, int j, int[][] grid, int ioff, int joff) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return false;
        if (grid[i][j] == 1) return true;
        return dfs(i+ioff, j+joff, grid, ioff, joff);
    }
}