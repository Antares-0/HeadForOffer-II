package HeadForOffer_II.Q101_Q110;

import java.util.Arrays;

public class Q106 {
    public static void main(String[] args) {

    }

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (!setcolor(graph, 0, i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
    // 深度优先——递归优质版本
    // 标准深度优先递归模板
    private boolean setcolor(int[][] graph, int color, int node, int colors[]) {
        if (colors[node] != -1){
            return colors[node] == color;
        }
        colors[node] = color;
        for (int neighbor : graph[node]) {
            if (!setcolor(graph,1-color,neighbor,colors)){
                return false;
            }
        }
        return true;
    }
// 深度优先——递归劣质版本
/*    // 深度优先搜索--递归解决A，这个版本比较一般，不算正规的模板
    private boolean setcolor(int[][] graph, int color, int node, int colors[]) {
        colors[node] = color;
        boolean answer = true;
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == -1) {
                answer = setcolor(graph,1- color,neighbor,colors);
            } else if (colors[neighbor] == color){
                return false;
            }
        }

        return answer;
    }*/
// 深度优先——栈
/*    // 深度优先搜索--循环解决
    private boolean setcolor(int[][] graph, int color,int node,int colors[]){
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        colors[node] = color;
        while(!stack.isEmpty()){
            int log_node = stack.pop();
            for (int neighbor : graph[log_node]){
                if (colors[neighbor] == -1){
                    stack.push(neighbor);
                    colors[neighbor] = 1- colors[log_node];
                } else {
                    if (colors[neighbor] == colors[log_node]){
                        return false;
                    }
                }
            }
        }
        return true;
    }*/
// 广度优先
/*    // 广度优先搜索
    private boolean setcolor(int[][] graph, int color,int node,int colors[]){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        colors[node] = color;
        while(!queue.isEmpty()){
            int log_node = queue.poll();
            for (int neighbor : graph[log_node]){
                if (colors[neighbor] != -1){
                    if (colors[neighbor] == colors[log_node]){
                        return false;
                    }
                } else {
                    queue.offer(neighbor);
                    colors[neighbor] = 1- colors[log_node];
                }
            }
        }
        return true;
    }*/
// 广度优先自己默写第一遍
/*    // 自己默写的广度优先搜索第一版，有很多错要注意
    public boolean isBipartite(int[][] graph) {
        int [] colors = new int[graph.length];
        Arrays.fill(colors,-1);
        for (int i = 0; i< graph.length;i++){
            if (colors[i] == -1) {
                if (!setcolor(graph, 0, i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean setcolor(int[][] graph, int color,int node,int colors[]){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        colors[node] = color;
        while(!queue.isEmpty()){
            int log_node = queue.poll();
            for (int neighbor : graph[log_node]){
                if (colors[neighbor] != -1){
                    if (colors[neighbor] == color){
                        return false;
                    }
                } else {
                    queue.offer(neighbor);
                    colors[neighbor] = 1- colors[node];
                }
            }
        }
        return true;
    }*/
}
