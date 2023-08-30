package algorithm.dynprogram;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSequence {

    /**
     * 1 + 1 + 2 + 3 +5 + 8 + 13
     *
     * @param N
     * @return
     */
    public static int fibonacciSequence(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return fibonacciSequence(N - 1) + fibonacciSequence(N - 2);
    }

    public static int fibonacciSequence1(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        return process(map, N);

    }

    private static int process(Map<Integer, Integer> map, int N) {
        if (map.containsKey(N)) {
            return map.get(N);
        } else {
            map.put(N, process(map, N - 1) + process(map, N - 2));
        }
        return map.get(N - 1) + map.get(N - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacciSequence(7));
        System.out.println(fibonacciSequence1(7));
    }
}
