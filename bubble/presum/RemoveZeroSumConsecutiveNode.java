package bubble.presum;
import java.util.*;
/**
 * RemoveZeroSumConsecutiveNode
 */
public class RemoveZeroSumConsecutiveNode {
    class Node {
        int value;
        Node next;
    };
    public Node solve(Node head) {
        if (head == null) return null;
        Node p = head;
        int preSum = 0;
        Map<Integer, Node> map = new HashMap<>();
        while (p!=null) {
            preSum += p.value;
            Node m = map.getOrDefault(preSum, null);
            if (m!=null) {
                m.next = p.next;
                map.remove(preSum);
            } 
            map.put(preSum, p);
            p = p.next;
        }
        return p;
    }
}