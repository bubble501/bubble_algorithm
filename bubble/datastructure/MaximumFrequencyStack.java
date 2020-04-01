package bubble.datastructure;
import java.util.*;

public class MaximumFrequencyStack {
    private Map<Integer, Integer> freqMap;
    private TreeMap<Integer, ArrayDeque<Integer>> invertedFreqMap;

    public MaximumFrequencyStack() {
        freqMap = new HashMap<>();
        invertedFreqMap = new TreeMap<>(Collections.reverseOrder());
    }

    public void push(int element) {
        int freq = freqMap.compute(element, (key, val)->(val==null) ? 1: val+1 );
        invertedFreqMap.computeIfAbsent(freq, key-> new ArrayDeque<>()).add(element); 
    }
    public int pop() {

        ArrayDeque<Integer> deq = invertedFreqMap.firstEntry().getValue();
        int element = deq.poll();
        if (deq.isEmpty()) {
            invertedFreqMap.remove(invertedFreqMap.firstKey());
        } 
        freqMap.compute(element, (key, val)->(val==1) ? null: val-1 );
        return element;
    }
}