import java.util.ArrayList;
import java.util.*;

public class PatternAnalyse {

    private ArrayList < Double > array;
    private List < Double > pattern;
    private int jump;
    private int size;

    public PatternAnalyse(ArrayList < Double > array, int jump, List < Double > pattern) {

        this.array = array;
        this.pattern = pattern;
        this.jump = jump;
        this.size = array.size();
    }

    public int probability() {

        int percentage = 0;
        int solution_index = size - 1;
        boolean is_solution_even = (solution_index % 2 == 0);
        boolean is_jump_even = (jump % 2 == 0);

        /* Calculate the best answer */
        List < Double > pattern_sorted = new ArrayList < Double > (pattern);
        Collections.sort(pattern_sorted);
        HashMap < Double, Integer > pattern_count = new HashMap < Double, Integer > ();


        int count_occ = 0;
        double last = 0;
        for (int i = 0; i < pattern_sorted.size(); i++) {

            if (i == 0) {
                count_occ = 1;
                last = pattern_sorted.get(i);
            }

            if (i > 0 && pattern_sorted.get(i) == last) {
                count_occ += 1;

            } else {
                count_occ = 1;
            }
            pattern_count.put(pattern_sorted.get(i), count_occ);
            last = pattern_sorted.get(i);
        }

        for (Map.Entry < Double, Integer > entry: pattern_count.entrySet()) {
            System.out.println("(" + entry.getKey() + " => " + entry.getValue() + ")");

        }


        /* Check for any number patterns in solution */


        /* If it will calculate the next number in serie */
        if (is_solution_even && is_jump_even || !is_solution_even && !is_jump_even)
            percentage += 50;

        /* If size of solutions is higher than two */
        if (size > 2)
            percentage += 10;

        return percentage;
    }


}
