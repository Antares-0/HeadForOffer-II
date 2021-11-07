package HeadForOffer_II.Q101_Q110;

public class Q105 {
    public static void main(String[] args) {

    }


    public int maxAreaOfIsland(int[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 1){
                    // int answer = bfs(visited,grid,i,j);
                    int answer = dfs(visited,grid,i,j);
                    max = Math.max(max,answer);
                }
            }
        }
        return max;
    }

    // 深度优先搜索——递归实现
    private int dfs(boolean [][] visited, int [][] grid, int a , int b){
        int area = 0;
        int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        visited[a][b] = true;
        for (int [] dir : dirs){
            int new_a = a + dir[0];
            int new_b = b + dir[1];
            if (new_a >= 0 && new_a < grid.length
                    && new_b >= 0 && new_b < grid[0].length
                    && !visited[new_a][new_b] && grid[new_a][new_b] == 1){
                area += dfs(visited,grid,new_a,new_b);
            }
        }
        return area + 1;
    }

/*    // 广度优先搜索
    private int bfs(boolean [][] visited, int [][] grid, int a , int b){
        Queue<int []> queue = new LinkedList<>();
        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        queue.add(new int[]{a,b});
        visited[a][b] = true;
        int area = 0;
        while (!queue.isEmpty()){
            area++;
            for (int [] dir : dirs){
                int [] log = queue.remove();
                int new_a = dir[0] + log[0];
                int new_b = dir[1] + log[1];
                if (new_a >= 0 && new_a < grid.length
                        && new_b >= 0 && new_b < grid[0].length
                        &&grid[new_a][new_b] ==1 && visited[new_a][new_b] == false){
                    queue.add(new int[]{new_a,new_b});
                    visited[new_a][new_b] = true;
                }
            }
        }
        return area;
    }*/

/*    // 深度优先搜索——栈实现
    private int dfs(boolean [][] visited, int [][] grid, int a , int b){
        Stack<int []> stack = new Stack<>();
        stack.push(new int[] {a,b});
        visited[a][b] = true;
        int dirs [][] = {{1,0},{0,1},{-1,0},{0,-1}};
        int area = 0;
        while (!stack.isEmpty()){
            int log []= stack.pop();
            area++;
            for (int [] dir :dirs){
                int new_a = dir[0] + log[0];
                int new_b = dir[1] + log[1];
                if (new_a >= 0 && new_a < grid.length
                        && new_b >= 0 && new_b < grid[0].length
                        &&grid[new_a][new_b] ==1 && !visited[new_a][new_b]){
                    stack.push(new int[] {new_a,new_b});
                    visited[new_a][new_b] = true;
                }
            }
        }
        return area;
    }*/

}
