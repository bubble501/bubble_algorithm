package bubble.unionfind;



/**
 * RedundantConnectionSolution
 */
public class RedundantConnectionSolution {
    static int MAX_EDGE_VAL = 1000;
    static class DSU {
        int[] parent;
        
        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
 
        }
    
        public int find(int x) {
            while(parent[x]!= x) {
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            parent[find(y)] = find(x);
 
        }
    }  
    
    public int[] find(int[][] edges) {
        DSU dsu = new DSU(MAX_EDGE_VAL + 1);
        for (int[] edge: edges) {
            if (dsu.find(edge[0])==dsu.find(edge[1])){
                return edge;
            }
            dsu.union(edge[0], edge[1]);
        }
        throw new AssertionError();
    }

    public  static void main(String[] args) {
        int[][] edges = new int[][]{
            {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}
        };
        RedundantConnectionSolution rcs = new RedundantConnectionSolution();
        int[] edge = rcs.find(edges);
        System.out.println("the edge is " + edge[0] +"," + edge[1]);
    }
    
    
}


