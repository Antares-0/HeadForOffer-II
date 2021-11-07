package HeadForOffer_II.Q111_Q119;

public class Q112 {
    public static void main(String[] args) {

    }

    public int longestIncreasingPath(int[][] matrix) {
        int [][] length = new int[matrix.length][matrix[0].length];
        int answer = 0;
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                answer = Math.max(answer,dfs(matrix,length,i,j));
            }
        }
        return answer;
    }

    private int dfs(int [][] matrix, int [][] length, int x, int y){
        if (length[x][y] != 0){
            return length[x][y];
        }
        int x_len = matrix.length;
        int y_len = matrix[0].length;
        int answer = 1;
        int [][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
        for (int[] dir : dirs){
            int new_x = dir[0] + x;
            int new_y = dir[1] + y;
            if (new_x >= 0 && new_x < x_len && new_y >= 0 && new_y < y_len && matrix[x][y] < matrix[new_x][new_y]){
                int path = dfs(matrix,length,x,y);
                answer = Math.max(path + 1,answer);
            }
        }
        length[x][y] = answer;
        return answer;
    }
}
