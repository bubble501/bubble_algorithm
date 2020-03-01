package bubble.interval;
import java.util.*;

/**
 * EmployeeFreeTimeSolution
 */
public class EmployeeFreeTimeSolution {

    public List<int[]> commonFreeTime(List<int[][]> schedule) {
        SortedMap<Integer, Integer> sm = new TreeMap<>();
        for (int[][] person : schedule) {
            for (int[] interval : person) {
                sm.put(interval[0], sm.getOrDefault(interval[0], 0)+ 1);
                sm.put(interval[1], sm.getOrDefault(interval[1], 0) -1);
            }
        }

        int workPersons = 0;
        int start = 0;
        int end = 0;
        List<int[]> res = new ArrayList<>();
        boolean isFreeTime = false;
        for(Integer point : sm.keySet()) {
            if (isFreeTime && (sm.getOrDefault(point, 0) > 0)) {
                end = point;
                res.add(new int[]{start ,end});
            }
            workPersons += sm.getOrDefault(point, 0);
            if (workPersons == 0) {
                start = point;
                isFreeTime = true;
            } else {
                isFreeTime = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // int[][] person1 = {{1, 2}, {5, 6}};
        // int[][] person2 = {{1, 3}};
        // int[][] person3 = {{4, 10}};
        int[][] person1 = {{1, 3}, {6, 7}};
        int[][] person2 = {{2, 4}};
        int[][] person3 = {{2, 5}, {9, 12}};
        List<int[][]> schedule = new ArrayList<>();
        schedule.add(person1);
        schedule.add(person2);
        schedule.add(person3);
        EmployeeFreeTimeSolution efs = new EmployeeFreeTimeSolution();
        List<int[]> res = efs.commonFreeTime(schedule);
        for (int[] interval : res) {
            System.out.println("[" + interval[0] + "," + interval[1]+"]");
        }
    }
}