package HeadForOffer_II.Q111_Q119;

import java.util.HashSet;
import java.util.Set;

public class Q118 {
    public static void main(String[] args) {

    }

    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int[] link : edges) {
            set.add(link[0]);
            set.add(link[1]);
        }
        int number_of_node = set.size();
        int[] nodes = new int[number_of_node + 1];
        for (int i = 1; i <= number_of_node; i++) {
            nodes[i] = i;
        }
        for (int[] edge :edges){
            int x = edge[0];
            int y = edge[1];
            if (!Union(nodes,x,y)){
                return edge;
            }
        }
        return new int[2];
    }

    private boolean Union(int[] fathers, int i, int j) {
        int i_ = findFather(fathers, i);
        int j_ = findFather(fathers, j);
        if (i_ != j_) {
            fathers[j_] = i_;
            return true;
            // 现在已经相连了
        }
        return false;
    }

    private int findFather(int[] father, int x) {
        if (father[x] != x){
            father[x] = findFather(father,father[x]);
        }
        return father[x];
    }

}
