package HeadForOffer_II.Q101_Q110;

import LeetCode.Graph.Q542;

import java.util.LinkedList;
import java.util.Queue;

public class Q107 {
    public static void main(String[] args) {
        Q542 i = new Q542();
        System.out.println(i.updateMatrix(new int[][] {{0,0,0},{0,1,0},{0,0,0}}));
    }

    public int[][] updateMatrix(int[][] mat) {
        int answer[][] = new int[mat.length][mat[0].length];
        Queue<int []> queue = new LinkedList<>();
        for (int i = 0;i<mat.length;i++){
            for (int j = 0;j<mat[0].length;j++){
                if (mat[i][j] == 0){
                    answer[i][j] = 0;
                    queue.offer(new int[]{i,j});
                } else {
                    answer[i][j] = 10001;
                }
            }
        }
        int [][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
        while (!queue.isEmpty()){
            int [] log = queue.poll();
            int x = log[0];
            int y = log[1];
            for (int[] dir : dirs){
                int x_ = dir[0] + x;
                int y_ = dir[1] + y;
                if (x_ >= 0 && x_ < mat.length && y_ >= 0 && y_ < mat[0].length && answer[x_][y_] == 10001){
                    answer[x_][y_] = answer[x][y] + 1;
                    queue.offer(new int []{x_,y_});
                }
            }
        }
        return answer;
    }
}
