package bubble.graph;
import java.util.*;

/**
 * FindItinerary
 */
public class FindItinerary {
    public String solve(Map<String, String> dataSet) {
        String start = null;
        Map<String, String> reverseMap = new HashMap<>();
        for(Map.Entry<String, String> entry: dataSet.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }
        for(Map.Entry<String, String> entry: dataSet.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                start = entry.getKey();
                break;
            }
        }
        return start;

    }
    
}