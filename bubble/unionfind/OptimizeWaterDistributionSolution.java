package bubble.unionfind;
import java.util.ArrayList;
/**
 * OptimizeWaterDistributionSolution
 */
public class OptimizeWaterDistributionSolution {
    static class DSU {
        private int[] parent;
        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while(x!=parent[x]) {
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    public int execute(int n, int[] wells, int[][] pipes) {
        DSU dsu = new DSU(n+1);
        ArrayList<int[]> costs = new ArrayList<>();
        for (int i = 0; i < wells.length; i++) {
            costs.add(new int []{wells[i], 0, i+1});
        }
        for (int i = 0; i < pipes.length; i++) {
            int[] pipe = pipes[i];
            costs.add(new int []{pipe[2], pipe[0], pipe[1]});
        }
        costs.sort((a, b)->a[0]-b[0]);
        int res = 0;
        for (int i = 0; i < costs.size(); i++) {
            int cost = costs.get(i)[0];
            int v1 = costs.get(i)[1];
            int v2 = costs.get(i)[2];
            if (dsu.find(v1) != dsu.find(v2)) {
                dsu.union(v1, v2);
                res += cost;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OptimizeWaterDistributionSolution os = new OptimizeWaterDistributionSolution();
        int n = 3;
        int[] wells = {1, 2, 3};
        int[][] pipes = {{1, 2, 1}, {2, 3, 1}};
        int res =os.execute(n, wells, pipes);
        System.out.println(res);
    }


    
}