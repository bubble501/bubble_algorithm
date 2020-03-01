package bubble.unionfind;

/**
 * RedundantConnection2Solution
 */
public class RedundantConnection2Solution {
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

    public  int[] find(int[][] edges) {
        int N = edges.length;
        int[][] res = {null, null};
         
        int[] parent = new int[N+1];
        boolean hasTwoParentsNode = false;
        for (int[] edge: edges) {
            int p = edge[0];
            int c = edge[1];
            if (parent[c] != 0) {
                res[0] = new int[] {parent[c], c};
                res[1] = new int[] {p, c};
                hasTwoParentsNode = true; 
                break;
            }
            parent[c] = p;
        }

        DSU dsu = new DSU(MAX_EDGE_VAL+1);
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            if (hasTwoParentsNode
                &&(
                    (u==res[0][0]&&v==res[0][1])
                    ||(u==res[1][0]&v==res[1][1])
                )
                ) {
                    continue;
                }
            if (dsu.find(u)==dsu.find(v)) {
                return edge;
            } else {
                dsu.union(u, v);
            }
        }

        if(hasTwoParentsNode&&(dsu.find(res[0][0])==dsu.find(res[0][1]))){
            return res[0];
        }

        return res[1];
    }

    public static void main(String[] args) {
        // int[][] edges = new int[][] {{1,2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        int[][] edges = new int[][] { {3, 1}, {4, 1}, {1,2}, {2, 3}};
 
        RedundantConnection2Solution rcs = new RedundantConnection2Solution();
        int[] edge = rcs.find(edges);
        System.out.println("the edge is " + edge[0] +"," + edge[1]);
    }
    
}