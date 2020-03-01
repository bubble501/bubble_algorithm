package bubble.monotone;
import java.util.*;
/**
 * DailyTemperaturesSolution
 */
public class DailyTemperaturesSolution {
    public int[] execute(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while ((deque.size() != 0)&&(temperatures[i] > temperatures[deque.peek()])) {
                int k = deque.pop();
                res[k] = i -k;
            }
            deque.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperaturesSolution dts = new DailyTemperaturesSolution();
        int[] res = dts.execute(temperatures);
        System.out.println(Arrays.toString(res));
    }
}