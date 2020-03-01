package bubble.unionfind;

/**
 * ReginCutBySlashesSolution
 */
public class ReginCutBySlashesSolution {

    static class DSU {
        private int[] parent;
        private int cnt;
        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            cnt = size;
        }

        public int find(int x) {
            while(parent[x]!= x) {
                x = parent[x];
            }
            return x;
        } 

        public void union(int x, int y) {
            int xv = find(x);
            int yv = find(y);
            if (xv != yv) {
                parent[yv] = xv;
                cnt--;
            }
        }
        public int getCnt() {
            return cnt;
        }
    }

    public int regionsBySlashes(String[] grid) {
        DSU dsu = new DSU(grid.length*grid[1].length()*4);
        for (int i = 0; i < grid.length; i++) {
            String str = grid[i];
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                int index = (i*grid.length +j)*4;
                if (ch=='/') {
                    dsu.union(index, index+3);
                    dsu.union(index+1, index+2);
                }
                if (ch=='\\') {
                    dsu.union(index, index+1);
                    dsu.union(index+2, index+3);
                }
                if (ch==' ') {
                    for (int k = 0; k < 4; k++) {
                        dsu.union(index+(k%4), index+(k+1)%4);
                    }
                }

                // union across cells
                //above
                if (i > 0) {
                    dsu.union(index-4*grid.length+2, index);
                }
                //right
                if (j < grid.length - 1) {
                    dsu.union(index+7, index+1);
                }
                //below
                if (i < grid.length -1) {
                    dsu.union(index+4*grid.length, index+2);
                }
                //left
                if (j > 0) {
                    dsu.union(index-3, index+3);
                }

            }
        } 
        return dsu.getCnt();
    }

    public static void main(String[] args) {
        ReginCutBySlashesSolution solution = new ReginCutBySlashesSolution();
        String [] grid = {"/\\", "\\/"};
        int cnt = solution.regionsBySlashes(grid);
        System.out.println("the count is " + cnt);

    }
}