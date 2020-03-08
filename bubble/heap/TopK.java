package bubble.heap;
import java.util.*;
/**
 * TopK
 */
public class TopK {
    public List<Integer> solve(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue  =
            new PriorityQueue<>((a, b)-> a.getValue() - b.getValue());
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
           queue.offer(entry);
           if (queue.size()> k) {
               queue.poll();
           } 
        }

        List<Integer> result = new ArrayList<>();
        while (queue.size() > 0) {
            result.add(queue.poll().getKey());
        }
        return result;
    }

    static class BucketSort {
        public List<Integer> solve(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0)+1);
            }

            int max = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max+1];
            for (int i = 1; i <= max; i++) {
                arr[i] = new ArrayList<Integer>();
            }

            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int count = entry.getValue();
                int number = entry.getKey();
                arr[count].add(number);
            }

            List<Integer> result = new ArrayList<Integer>();
            //add most frequent numbers to result
            for(int j=max; j>=1; j--){
                if(arr[j].size()>0){
                    for(int a: arr[j]){
                        result.add(a);
                        //if size==k, stop
                        if(result.size()==k){
                            return result;
                        }
                    }
                }
            }
                
            return result;

        }
    }
    
}