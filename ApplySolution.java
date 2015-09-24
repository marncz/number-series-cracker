import java.util.ArrayList;
import java.util.*;

public class ApplySolution {

    private static ArrayList < Double > array;
    private static double answer;
    private static int jump;
    private String action;
    public static boolean solved = false;

    public ApplySolution(ArrayList < Double > array, int jump, double answer, String action) {

        this.array = array;
        this.answer = answer;
        this.jump = jump;
        this.action = action;
    }

    public static void solved_set(boolean set) {
        solved = false;
    }

    public static boolean solved() {
        return solved;
    }

    public void apply_answer() {
		List < Double > array_copy = new ArrayList < Double > (array);
        double solution = 0;
        if (this.action == "add")
            solution = array_copy.get(array_copy.size() - jump) + answer;

        if (this.action == "multiply")
            solution = array_copy.get(array_copy.size() - jump) * answer;

        solved_set(true);
        array_copy.add(solution);
        System.out.println();
        System.out.print("Solution: ");
        for (int i = 0; i < array_copy.size(); i++) {
            System.out.print("[" + array_copy.get(i) + "]");
        }
        System.out.println();
		
    }



}
