package HeadForOffer_II.Q111_Q119;

public class Q116 {
    public static void main(String[] args) {

    }
    // 并查集
    public int findCircleNum(int[][] isConnected) {
        int [] fathers = new int[isConnected.length];
        for (int i = 0;i<isConnected.length;i++){
            fathers[i] = i;
        }
        int count = isConnected.length;
        for (int i = 0;i<fathers.length;i++){
            for (int j = i + 1;j<fathers.length;j++){
                if (isConnected[i][j] == 1 && Union(fathers,i,j)){
                    count--;
                }
            }
        }
        return count;
    }

    private int findFather(int [] fathers,int i){
        if (fathers[i] != i){
            fathers[i] = findFather(fathers,fathers[i]);
        }
        return fathers[i];
    }

    private boolean Union(int [] father ,int a ,int b){
        int father_of_a = findFather(father,a);
        int father_of_b = findFather(father,b);
        if (father_of_a != father_of_b){
            father[father_of_a] = father_of_b;
            return true;
        }
        return false;
    }

}
