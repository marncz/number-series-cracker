import java.util.ArrayList;
import java.util.*;

public class Cracker {

    public Cracker(ArrayList < Double > array) {

        for (int i = 0; i < array.size(); i++) {
            System.out.println("[" + i + "] " + array.get(i));
        }

        for (int a = 0; a < 2; a++) {
            crack(a, array);
        }
    }

    public void found(int sol) {
        System.out.println("Found solution!" + sol);
    }

    /* List of cracking functions */

    public double diff(double a, double b) {
        return b - a;
    }

    public double multiply(double a, double b) {
       return b / a;
    }


    public void crack(int method, ArrayList < Double > array) {
       if (ApplySolution.solved() == false){
        System.out.println();
        HashMap < Integer, List < Double >> array_map = new HashMap < Integer, List < Double >> ();
		
        for (int c = 1; c < array.size(); c++) {
            List < Double > sum_list = new ArrayList < Double > ();
            for (int a = 0; a < array.size(); a++) {
				
                for (int b = 0; b < array.size(); b++) {
                    if (a < b && b - a == c) {

                        if (method == 0) {
                            sum_list.add(diff(array.get(a), array.get(b)));
                        }
                        if (method == 1) {
                            sum_list.add(multiply(array.get(a), array.get(b)));
                        }

                    }
                }
            }

            array_map.put(c, sum_list);
			

        }
          
        String action = "";
        if (method == 0) {
            System.out.println("*** Diff function for (jumps) ***");
            action = "add";
        }
        if (method == 1) {
            System.out.println("*** Multiply funtion for (jumps) ***");
            action = "multiply";
        }
 
        for (Map.Entry < Integer, List < Double >> entry: array_map.entrySet()) {
            PatternAnalyse pattern = new PatternAnalyse(array, entry.getKey(),entry.getValue(),action);
            int prob = pattern.probability();
            	
			System.out.println("(" + entry.getKey() + ") " + entry.getValue() + " (" + prob +"%)");
			
        }
	
		
       
	}
    }

}
