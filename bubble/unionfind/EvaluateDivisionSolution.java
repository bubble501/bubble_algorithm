package bubble.unionfind;

import java.util.Map;
import java.util.HashMap;


class MyNode {
    private String parent;
    private float ratio;
    public MyNode(String parent, float ratio) {
        this.parent = parent;
        this.ratio = ratio;
    }

    public String getParent() {
        return this.parent;
    }

    public float getRatio() {
        return this.ratio;
    }
}

/**
 * EvaluateDivision
 */
public class EvaluateDivisionSolution {
    private Map<String, MyNode> m;

    public EvaluateDivisionSolution() {
        this.m = new HashMap<>();
    }

    public void union(String str1, String str2, float ratio) {
        MyNode n1 = this.find(str1);
        MyNode n2 = this.find(str2);
        this.m.put(n2.getParent(), new MyNode(n1.getParent(), n1.getRatio()*ratio/n2.getRatio()));
    }

    public MyNode find(String str1) {
        float r = this.m.get(str1).getRatio();
        String p = this.m.get(str1).getParent();
        while (str1.equals(p)==false) {
            str1 = p;
            p = this.m.get(p).getParent();
            r = r * this.m.get(p).getRatio();
        }
        return new MyNode(p, r);
    }



    public float[] calcEquation(
             String[][] equations,
             float[] values,
             String[][] queries) {
                 float[] res = new float[queries.length];
                 for (int i=0; i < equations.length; i++) {
                     String v1 = equations[i][0];
                     String v2 = equations[i][1];
                     this.m.put(v1, new MyNode(v1, 1));
                     this.m.put(v2, new MyNode(v2, 1));
                 }
                 for (int i=0; i < equations.length; i++) {
                     String v1 = equations[i][0];
                     String v2 = equations[i][1];
                     this.union(v1, v2, 1/values[i]);
                 }

                 for (int i = 0; i < queries.length; i++) {
                     String v1 = queries[i][0];
                     String v2 = queries[i][1];
                     if (this.m.containsKey(v1)==false){
                        res[i] = -1;
                        continue;
                     }
                     if (this.m.containsKey(v2)==false) {
                         res[i] = -1;
                         continue;
                     }

                     MyNode n1 = this.find(v1);
                     MyNode n2 = this.find(v2);
                     if (n1.getParent().equals(n2.getParent())==false) {
                        res[i]  = -1;
                     } else {
                         res[i] = n1.getRatio() / n2.getRatio();
                     }
                 }
                 return res;
             }

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        float[] values = {2.0f, 3.0f};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "c"}, {"a", "a"}, {"x", "x"}};
        EvaluateDivisionSolution es = new EvaluateDivisionSolution();
        float[] res = es.calcEquation(equations, values, queries);
        for(float e : res) {
            System.out.println(e);
        }
        // System.out.println(res);

    }
}