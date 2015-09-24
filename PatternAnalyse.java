import java.util.ArrayList;
import java.util.*;

public class PatternAnalyse {

    private ArrayList < Double > array;
    private List < Double > pattern;
    private int jump;
    private int size;
    private int patternSize;
	public int percentage = 0;
	public String action;
	
    public PatternAnalyse(ArrayList < Double > array, int jump, List < Double > pattern, String action) {

        this.array = array;
        this.pattern = pattern;
        this.jump = jump;
        this.size = array.size();
        this.patternSize = pattern.size();
        this.action = action;
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

		/* Count */
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
         if(entry.getValue() >= (patternSize/2.1))
			this.percentage += 60;
			
        }
        
       
 

        /* Check for any number patterns in solution */


        /* If it will calculate the next number in serie */
        if (is_solution_even && is_jump_even || !is_solution_even && !is_jump_even)
            this.percentage += 30;

        /* If size of solutions is higher than two */
        if (size > 2)
            this.percentage += 10;

			
	   
		   
		   if(this.percentage > 50){
			   
		   find_solution(pattern_count);
		  
		}
		   return this.percentage;
		   
    }
    
    public void find_solution (HashMap<Double, Integer> pattern_count) {
		
		int max = 0;
		double key = 0;
		for (Map.Entry < Double, Integer > entry: pattern_count.entrySet()) {
           
			
			//System.out.println("(" + entry.getKey() + " => " + entry.getValue() + ")");
			if(entry.getValue() > max) {max = entry.getValue(); key = entry.getKey();
			
					
		 	
        }
        
				ApplySolution.solved_set(true);
				ApplySolution solution = new ApplySolution(array,jump,key,action);
				solution.apply_answer();
		
		
	}
}
  public boolean check_solution(){
	  
	  
	  return true;
  }


}
